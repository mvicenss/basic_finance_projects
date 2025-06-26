import java.util.Scanner;

class CalculatorMain{
    public static void main(String[] args) {
        System.out.println("Welcome! What do you want to do?");
        System.out.println("1. Supermarket");
        System.out.println("2. Loan");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("What do you want to do?");
                System.out.println("a. Add a product to ticket");
                System.out.println("b. Subtract a product from ticket");
                System.out.println("c. Get total tax value");
                System.out.println("d. Get total value of ticket");
            case 2:
        }
    }
    }
