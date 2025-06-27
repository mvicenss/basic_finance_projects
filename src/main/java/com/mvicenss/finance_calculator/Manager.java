import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Manager {
    HashMap<String, Double> productList = new HashMap<String, Double>(); //Map for each kind of product

    //Arrays for tax type differentiation
    ArrayList<SimpleEntry<String, Double>> supereduced = new ArrayList<>();
    ArrayList<SimpleEntry<String, Double>> reduced = new ArrayList<>();
    ArrayList<SimpleEntry<String, Double>> general = new ArrayList<>();

    private static final String ticket = "ticket.csv";

    //Constructor -- Loads all data when initializing the program
    public Manager(){
        loadFromFile();
    }

    //IMP: SAVING ARRAY CONTENTS TO A FILE
    public void saveToFile(){
        try(FileWriter writer = new FileWriter(ticket)){ //If the file exists
            writer.write("name, taxType, price \n");
            for(SimpleEntry<String, Double> entry : supereduced){
                writer.write(entry.getKey() + " ,0.04," + entry.getValue() + "\n");
            }
            for(SimpleEntry<String, Double> entry : reduced){
                writer.write(entry.getKey() + " ,0.10," + entry.getValue() + "\n");
            }
            for(SimpleEntry<String, Double> entry : general){
                writer.write(entry.getKey() + " ,0.21," + entry.getValue() + "\n");
            }
        }catch(IOException e){
            System.out.println("Error when saving data: " + e);
        }
    }

    private void loadFromFile(){
        File file = new File(ticket);

        if(!file.exists()){
            return;
        }

        try(Scanner scanner = new Scanner(file)){ //Reading the file
            if(scanner.hasNextLine()){ //If the file has content, keep reading
                scanner.nextLine();
            }

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(","); //String to dividide the parts + divider

                if(parts.length == 3){ //If each line has 3 "parts", divided by ","
                    String name = parts[0];
                    double taxType = Double.parseDouble(parts[1]);
                    double price = Double.parseDouble(parts[2]);

                    Products product = new Products(name, taxType, price);
                    addProduct(product);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("No such file: " + e.getMessage());
        }
    }

    //1. ADD A PRODUCT
    public void addProduct(Products product) {
        if(!productList.containsKey(product.getName())) {
            productList.put(product.getName(), product.getTaxType());
        }
        // "Object" of SimpleEntry == Product that will be added to the corresponding ArrayList
        SimpleEntry<String, Double> entry = new SimpleEntry<>(product.getName(), product.getGrossAmount());

        double taxType = product.getTaxType();
        if(taxType == 0.04){
            supereduced.add(entry);
        }else if(taxType == 0.10){
            reduced.add(entry);
        }else{
            general.add(entry);
        }

        saveToFile();

    }

    //2. REMOVE A PRODUCT BY NAME
    public boolean removeByName(String productName){

        boolean productFound = productList.containsKey(productName);

        if(productFound){
            productList.remove(productName);
            supereduced.removeIf(entry -> entry.getKey().equals(productName));
            reduced.removeIf(entry -> entry.getKey().equals(productName));
            general.removeIf(entry -> entry.getKey().equals(productName));
            //Lambda expression operation:
            //Removes the element in the corresponding ArrayList if, for the object "entry" the corresponding Key on the HashMap matches the name to remove
            saveToFile();
            return true;
        }else{
            System.out.println("Product not found/Not logged: " + productName);
            return false;
        }



    }

    //3. TOTAL TAX VALUE
    public double totalTax(){

        if(supereduced.isEmpty()&&reduced.isEmpty()&&general.isEmpty()){
            System.out.println("No products to calculate tax with.");
            return 0.0;
        }
        double supereducedTax = 0;
        double reducedTax = 0;
        double generalTax = 0;
        for(SimpleEntry<String, Double> entry : supereduced){
            double unitaryTaxSr = entry.getValue() * 0.04;
            supereducedTax = unitaryTaxSr + supereducedTax;
        }
        for(SimpleEntry<String, Double> entry : reduced){
            double unitaryTaxR = entry.getValue() * 0.10;
            reducedTax = unitaryTaxR + reducedTax;
        }
        for(SimpleEntry<String, Double> entry : general){
            double unitaryTaxG = entry.getValue() * 0.21;
            generalTax = generalTax + unitaryTaxG;
        }

        return generalTax + reducedTax + supereducedTax;
    }

    //4. TOTAL VALUE OF TICKET (including tax)
    public double totalTicket(){

        if(supereduced.isEmpty() && reduced.isEmpty() && general.isEmpty()){
            System.out.println("Ticket is empty");
            return 0.0;
        }

        double totalSr = 0;
        double totalR = 0;
        double totalG = 0;

        for(SimpleEntry<String, Double> entry : supereduced){
            double price = entry.getValue();
            double unitaryTicketSr = entry.getValue() * 0.04;
            double valueSr = price + unitaryTicketSr; //Calculating final unitary price
            totalSr = totalSr + valueSr; //Adding to total price of array
        }
        for(SimpleEntry<String, Double> entry : reduced){
            double price = entry.getValue();
            double unitaryTicketR = entry.getValue() * 0.10;
            double valueR = price + unitaryTicketR;
            totalR = totalR + valueR;
        }
        for(SimpleEntry<String, Double> entry : general){
            double price = entry.getValue();
            double unitaryTicketG = entry.getValue() * 0.21;
            double valueG = price + unitaryTicketG;
            totalG = totalG + valueG;
        }
        return  totalSr + totalR + totalG;
    }
}
