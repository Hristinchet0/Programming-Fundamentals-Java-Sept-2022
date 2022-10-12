
import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String productInput = scanner.nextLine();
        double quantityInput = Double.parseDouble(scanner.nextLine());

        switch (productInput) {
            case "coffee" :
                orderCalculation(quantityInput, 1.5);

                break;
            case "water":
                orderCalculation(quantityInput, 1.0);

                break;
            case "coke":
                orderCalculation(quantityInput, 1.4);

                break;
            case "snacks":
                orderCalculation(quantityInput, 2.00);

                break;

        }
    }
    public static void orderCalculation(double quantity, double price) {
        double totalPrice = quantity * price;
        System.out.printf("%.2f", totalPrice);
    }
}
