import java.util.ArrayList;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;


public class Manager {
    HashMap<String, Double> productList = new HashMap<String, Double>(); //Map for each kind of product

    //Arrays for tax type differentiation
    ArrayList<SimpleEntry<String, Double>> supereduced = new ArrayList<>();
    ArrayList<SimpleEntry<String, Double>> reduced = new ArrayList<>();
    ArrayList<SimpleEntry<String, Double>> general = new ArrayList<>();

    //1. ADD A PRODUCT
    public void addProduct(Products product) {
        if(!productList.containsKey(product.getName())) {
            productList.put(product.getName(), product.getTaxType());
        }
        // "Object" of SimpleEntry == Product that will be added to the corresponding ArrayList
        SimpleEntry<String, Double> entry = new SimpleEntry<>(product.getName(), product.getTaxType());

        double taxType = product.getTaxType();
        if(taxType == 0.04){
            supereduced.add(entry);
        }else if(taxType == 0.10){
            reduced.add(entry);
        }else{
            general.add(entry);
        }
    }

    //2. REMOVE A PRODUCT BY NAME
    public void removeByName(String productName){
        if(productList.containsKey(productName)){
            productList.remove(productName);
        }

        supereduced.removeIf(entry -> entry.getKey().equals(productName));
        reduced.removeIf(entry -> entry.getKey().equals(productName));
        general.removeIf(entry -> entry.getKey().equals(productName));
        //Lambda expression operation:
        //Removes the element in the corresponding ArrayList if, for the object "entry" the corresponding Key on the HashMap matches the name to remove
    }
}
