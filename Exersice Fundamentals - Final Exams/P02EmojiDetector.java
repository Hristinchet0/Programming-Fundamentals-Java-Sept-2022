import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String digitRegex = "\\d";
        Pattern digitPattern = Pattern.compile(digitRegex);
        Matcher digitMatcher = digitPattern.matcher(input);
        int sum = 1;

        while (digitMatcher.find()) {
            int digit = Integer.parseInt(digitMatcher.group(0));
            sum *= digit;
        }

        String regex = "(\\:\\:|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> emojies = new ArrayList<>();
        List<String> coolEmojies = new ArrayList<>();

        while (matcher.find()) {
            String currentEmoji = matcher.group();
            emojies.add(currentEmoji);

            int sumSymbols = 0;
            for (int i = 0; i < currentEmoji.length(); i++) {
                char symbol = currentEmoji.charAt(i);
                if(Character.isLetter(symbol)) {
                    sumSymbols += symbol;
                }
            }

            if(sumSymbols > sum) {
                coolEmojies.add(currentEmoji);
            }
        }
        System.out.printf("Cool threshold: %d%n",sum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n",emojies.size());

        coolEmojies.forEach(System.out::println);

    }
}
