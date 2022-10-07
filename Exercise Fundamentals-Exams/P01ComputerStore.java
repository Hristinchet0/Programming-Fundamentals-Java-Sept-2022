import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalPriceWithoutTax = 0;
        double totalTax = 0; //totalPriceWithTax - totalPriceWithoutTax;
        double totalPrice = 0; //totalPriceWithoutTax + totalPriceWithTax;
        double discount = 0;

        while(!input.equals("special") && !input.equals("regular")) {

            double partsPrice = Double.parseDouble(input);

            if (partsPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
            } else {
                totalPriceWithoutTax += partsPrice;
                totalTax = totalPriceWithoutTax * 0.2;
                totalPrice = totalPriceWithoutTax + totalTax;
                input = scanner.nextLine();
            }


            //input = scanner.nextLine();
        }


        if ("special".equals(input)) {
            discount = totalPrice * 0.1;
            totalPrice = totalPrice - discount;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n", totalPriceWithoutTax, totalTax, totalPrice);
        }

    }
}
