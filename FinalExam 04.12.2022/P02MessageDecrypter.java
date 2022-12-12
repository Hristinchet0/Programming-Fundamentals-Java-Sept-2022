import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            String message = scanner.nextLine();

            String regex = "^([%$])(?<tag>[A-Z][a-z]{2,})\\1:\\s+\\[(?<first>\\d+)\\]\\|\\[(?<second>\\d+)\\]\\|\\[(?<third>\\d+)\\]\\|$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                int first = Integer.parseInt(matcher.group("first"));
                char char1 = (char) first;
                int second = Integer.parseInt(matcher.group("second"));
                char char2 = (char) second;
                int third = Integer.parseInt(matcher.group("third"));
                char char3 = (char) third;
                String decryptedMessage = "" + char1 + char2 + char3;
                System.out.printf("%s: %s%n", tag, decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }


        }
    }
}
