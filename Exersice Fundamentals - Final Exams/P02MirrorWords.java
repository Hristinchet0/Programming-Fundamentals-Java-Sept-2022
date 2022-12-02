import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([#@])(?<word1>[A-Za-z]{3,})\\1{2}(?<word2>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> mirrorWords = new ArrayList<>();
        int counter = 0;

        while (matcher.find()) {
            counter++;

            String word1 = matcher.group("word1");
            String word2 = matcher.group("word2");

            String reversedWord1 = new StringBuilder(word1).reverse().toString();
            if(reversedWord1.equals(word2)) {
                mirrorWords.add(word1 + " <=> " + word2);
            }
        }
        if (counter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", counter);
        }
        if (mirrorWords.size() < 1) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }

    }
}
