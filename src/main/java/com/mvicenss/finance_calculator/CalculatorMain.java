import java.util.Scanner;

class CalculatorMain{
    public static void main(String[] args) {

        System.out.println("What do you want to do?");
        System.out.println("a. Add a product to ticket");
        System.out.println("b. Subtract a product from ticket");
        System.out.println("c. Get total tax value");
        System.out.println("d. Get total value of ticket");

        Scanner sc = new Scanner(System.in);
        char subOption = sc.nextLine().charAt(0);

        Manager manager = new Manager();


        switch (subOption){
            case 'a':
                System.out.println("Name of the product");
                String name = sc.nextLine();
                System.out.println("Tax type (0.04, 0.1 or 0.21)");
                double taxType;
                try{
                    taxType = Double.parseDouble(sc.nextLine());
                }catch(NumberFormatException e){
                    System.out.println("Invalid tax type");
                    break;
                }
                System.out.println("Gross price");
                double grossAmount;
                try{
                    grossAmount = Double.parseDouble(sc.nextLine());
                }catch(NumberFormatException e){
                    System.out.println("Invalid price");
                    break;
                }

                Products product = new Products(name, taxType, grossAmount);
                manager.addProduct(product);
                System.out.println("Product added successfully");
                break;
            case 'b':
                System.out.println("Name of the product");
                String nameToRemove = sc.nextLine();

                if(manager.removeByName(nameToRemove)){
                    System.out.println("Product removed successfully");
                }
                break;

            case 'c':
                System.out.println("Total tax of the ticket = " + manager.totalTax());
                break;

            case 'd':
                System.out.println("Total value of the ticket = " + manager.totalTicket());
                }
    }
}
