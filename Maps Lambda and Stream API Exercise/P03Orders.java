import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        while (!command.equals("buy")) {
            String[] productArr = command.split(" ");
            //name, a price, and its quantity.
            String name = productArr[0];
            double price = Double.parseDouble(productArr[1]);
            int quantity = Integer.parseInt(productArr[2]);

            productsPrice.put(name, price);

            if (!productsQuantity.containsKey(name)) {
                productsQuantity.put(name, quantity);
            } else {
                productsQuantity.put(name, productsQuantity.get(name) + quantity);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue() * productsQuantity.get(entry.getKey()));
        }

    }
}
