import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double currentBalance = Double.parseDouble(input);
        double totalMoney = currentBalance;
        double totalSpend = 0;
        double price;

        while (!"Game time".equalsIgnoreCase(input = scanner.nextLine())) {

            price = 0;

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }

            switch (input) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            if (currentBalance >= price && price > 0) {

                totalSpend += price;
                currentBalance -= price;
                System.out.printf("Bought %s%n", input);

            }else if (currentBalance < price && price > 0) {

                System.out.println("Too Expensive");
            }
        }
        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpend, (totalMoney - totalSpend));
        }

    }

}

