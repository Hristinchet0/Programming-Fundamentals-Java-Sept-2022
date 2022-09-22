import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalMoneyInserted = 0;
        while (!input.equals("Start")) {

            //Until you receive "Start" you will be given different coins that are being inserted into the machine.
            // You have to sum them to have the total money inserted. There is a problem though.
            // Your vending machine only works with 0.1, 0.2, 0.5, 1, and 2 coins.
            // If someone tries to insert some other coins, you have to display "Cannot accept {money}",
            double coinInserted = Double.parseDouble(input);

            if (coinInserted == 0.1 || coinInserted == 0.2 || coinInserted == 0.5 || coinInserted == 1 || coinInserted == 2) {
                totalMoneyInserted += coinInserted;
            } else {
                System.out.printf("Cannot accept %.2f%n", coinInserted);
            }

            input = scanner.nextLine();

        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            // "Nuts", "Water", "Crisps", "Soda", "Coke". The prices are: 2.0, 0.7, 1.5, 0.8, 1.0
            // a not existing product, print "Invalid product"
            //". Be careful that the person may try to purchase a product for which he doesn't have money.
            // In that case, print "Sorry, not enough money". If the person purchases a product successfully
            // print "Purchased {product name}". After the "End" command,
            // print the money that is left formatted to the second decimal point in the format "Change: {money left}".
            switch (input) {
                case "Nuts":
                    if (totalMoneyInserted >= 2.0) {
                        System.out.println("Purchased Nuts");
                        totalMoneyInserted -= 2.0;
                    } else  {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (totalMoneyInserted >= 0.7) {
                        System.out.println("Purchased Water");
                        totalMoneyInserted -= 0.7;
                    } else  {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (totalMoneyInserted >= 1.5) {
                        System.out.println("Purchased Crisps");
                        totalMoneyInserted -= 1.5;
                    } else  {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (totalMoneyInserted >= 0.8) {
                        System.out.println("Purchased Soda");
                        totalMoneyInserted -= 0.8;
                    } else  {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (totalMoneyInserted >= 1.0) {
                        System.out.println("Purchased Coke");
                        totalMoneyInserted -= 1.0;
                    } else  {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();

        }

        System.out.printf("Change: %.2f", totalMoneyInserted);
    }
}
