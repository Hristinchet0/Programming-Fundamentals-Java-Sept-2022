import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalPriceWithoutTax = 0;
        double totalTax = 0; //totalPriceWithTax - totalPriceWithoutTax;
        double totalPrice = 0; //totalPriceWithoutTax + totalPriceWithTax;
        double discount;

        while(!input.equals("special") && !input.equals("regular")) {

            double partsPrice = Double.parseDouble(input);

            if (partsPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceWithoutTax += partsPrice;
                totalTax = totalPriceWithoutTax * 0.2;
                totalPrice = totalPriceWithoutTax + totalTax;
            }
            input = scanner.nextLine();


            //input = scanner.nextLine();
        }


        if ("special".equals(input)) {
            discount = totalPrice * 0.1;
            totalPrice = totalPrice - discount;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("""
                    Congratulations you've just bought a new computer!
                    Price without taxes: %.2f$
                    Taxes: %.2f$
                    -----------
                    Total price: %.2f$
                    """, totalPriceWithoutTax, totalTax, totalPrice);
        }

    }
}
