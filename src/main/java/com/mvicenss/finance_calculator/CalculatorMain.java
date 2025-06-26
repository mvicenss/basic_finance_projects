import java.util.Scanner;

class CalculatorMain{
    public static void main(String[] args) {
        System.out.println("Welcome! What do you want to do?");
        System.out.println("1. Supermarket");
        System.out.println("2. Loan");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        Manager manager = new Manager();

        switch (option){
            case 1:
                System.out.println("What do you want to do?");
                System.out.println("a. Add a product to ticket");
                System.out.println("b. Subtract a product from ticket");
                System.out.println("c. Get total tax value");
                System.out.println("d. Get total value of ticket");

                char subOption = sc.nextLine().charAt(0);

                switch (subOption){
                    case 'a':
                        System.out.println("Name of the product");
                        String name = sc.nextLine();
                        System.out.println("Tax type");
                        double taxType = sc.nextDouble();
                        System.out.println("Gross price");
                        double grossAmount = sc.nextDouble();

                        Products product = new Products(name, taxType, grossAmount);
                        manager.addProduct(product);
                        System.out.println("The product has been added");
                        break;
                    case 'b':
                        System.out.println("Name of the product");
                        String nameToRemove = sc.nextLine();

                        manager.removeByName(nameToRemove);
                        System.out.println("The product has been removed");
                        break;

                }
            case 2:
        }
    }
    }
