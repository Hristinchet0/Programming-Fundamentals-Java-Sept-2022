import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();

        String regexInfo = "(#|\\|)(?<itemName>[A-Za-z]+\\s?[A-Za-z]+)\\1(?<expDate>[0-9][0-9]\\/[0-9][0-9]\\/[0-9][0-9])\\1(?<calories>[0-9]+)\\1";
        Pattern patternInfo = Pattern.compile(regexInfo);
        Matcher matcherInfo = patternInfo.matcher(info);
        int totalCalories = 0;
        List<String> infoList = new ArrayList<>();
        while (matcherInfo.find()) {
            String itemName = matcherInfo.group("itemName");
            String expDate = matcherInfo.group("expDate");
            int calories = Integer.parseInt(matcherInfo.group("calories"));
            totalCalories = totalCalories + calories;
            infoList.add(String.format("Item: %s, Best before: %s, Nutrition: %d%n", itemName, expDate, calories));

        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);

        for (String item : infoList) {
            System.out.print(item);
        }

    }
}
