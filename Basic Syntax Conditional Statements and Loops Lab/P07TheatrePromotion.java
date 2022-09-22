import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int agePerson = Integer.parseInt(scanner.nextLine());
        int priceTicket = 0;
        boolean isValid = true;

        if (agePerson >= 0 && agePerson <= 18) {
            switch (typeOfDay) {
                case "Weekday":
                    priceTicket = 12;
                    break;
                case "Weekend":
                    priceTicket = 15;
                    break;
                case "Holiday":
                    priceTicket = 5;
                    break;
                default:
                    isValid = false;
                    break;
            }
        } else if (agePerson > 18 && agePerson <= 64) {
            switch (typeOfDay) {
                case "Weekday":
                    priceTicket = 18;
                    break;
                case "Weekend":
                    priceTicket = 20;
                    break;
                case "Holiday":
                    priceTicket = 12;
                    break;
                default:
                    isValid = false;
                    break;
            }
        } else if (agePerson > 64 && agePerson <= 122) {
            switch (typeOfDay) {
                case "Weekday":
                    priceTicket = 12;
                    break;
                case "Weekend":
                    priceTicket = 15;
                    break;
                case "Holiday":
                    priceTicket = 10;
                    break;
                default:
                    isValid = false;
                    break;
            }
        } else {
            isValid = false;
        }

        if (!isValid) {
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", priceTicket);
        }
    }
}
