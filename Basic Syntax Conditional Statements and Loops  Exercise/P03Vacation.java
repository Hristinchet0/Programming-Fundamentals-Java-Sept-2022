import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String typeTickets = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        switch (day) {
            case "Friday":
                if (typeTickets.equals("Students")) {
                    price = 8.45;
                } else if (typeTickets.equals("Business")) {
                    price = 10.90;
                } else if (typeTickets.equals("Regular")) {
                    price = 15.00;
                }
                break;
            case "Saturday":
                if (typeTickets.equals("Students")) {
                    price = 9.80;
                } else if (typeTickets.equals("Business")) {
                    price = 15.60;
                } else if (typeTickets.equals("Regular")) {
                    price = 20.00;
                }
                break;
            case "Sunday":
                if (typeTickets.equals("Students")) {
                    price = 10.46;
                } else if (typeTickets.equals("Business")) {
                    price = 16.00;
                } else if (typeTickets.equals("Regular")) {
                    price = 22.50;
                }
                break;
        }
        double totalPrice = price * people;

        if (typeTickets.equals("Students") && people >= 30) {
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (typeTickets.equals("Business") && people >= 100) {
            totalPrice = (people - 10) * price;
        } else if (typeTickets.equals("Regular") && people >= 10 && people <= 20) {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
