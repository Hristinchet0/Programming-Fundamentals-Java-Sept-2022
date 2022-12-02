import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> furnitureNames = new ArrayList<>();//имената на мебелите
        double totalSum = 0; //общо изхарчената сума за всички въведени мебели
        String input = scanner.nextLine();

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        while (!input.equals("Purchase")) {
            //">>{furniture name}<<{price}!{quantity}"
            //>>Sofa<<312.23!3
            Matcher matcher = pattern.matcher(input);
            //Matcher = ">>(?<furniture>Sofa)<<(?<price>312.23)!(?<quantity>3)"
            //true = input отговаря на шаблона
            //false = input не отговаря на шаблона
            if (matcher.find()) {
                String furnitureName = matcher.group("furniture"); //sofa
                double price = Double.parseDouble(matcher.group("price")); //312.23
                int quantity = Integer.parseInt(matcher.group("quantity")); //3

                furnitureNames.add(furnitureName);
                double currentFurniturePrice = price * quantity;
                totalSum += currentFurniturePrice;
            }


            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furnitureNames.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
