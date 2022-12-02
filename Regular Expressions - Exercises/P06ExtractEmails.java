import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information.

        String regex = "(?<user>[A-Za-z0-9]+[._-]?[A-Za-z0-9]+)@(?<host>(?<word1>[A-Za-z]+-?[A-Za-z]+(?<word2>\\.[A-Za-z]+-?[A-Za-z]+)+))";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input); //всички текстове които отговарят на шаблона
        //matcher = s.miller@mit.edu, j.hopking@york.ac.uk

        while (matcher.find()) {
            System.out.println(matcher.group()); // отпечатва всичко в matcher-a (всчики групи от регекса)
        }

    }
}
