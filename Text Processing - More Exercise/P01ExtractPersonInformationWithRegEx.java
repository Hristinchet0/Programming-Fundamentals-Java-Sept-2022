import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01ExtractPersonInformationWithRegEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String regexName = "@(?<name>[A-Za-z]+)\\|";
            Pattern patternName = Pattern.compile(regexName);
            Matcher matcherName = patternName.matcher(input);

            String regexAge = "#(?<age>[0-9]+)\\*";
            Pattern patternAge = Pattern.compile(regexAge);
            Matcher matcherAge = patternAge.matcher(input);

            while (matcherName.find() && matcherAge.find()) {
                System.out.printf("%s is %s years old.%n", matcherName.group("name"), matcherAge.group("age"));
            }
        }
    }
}
