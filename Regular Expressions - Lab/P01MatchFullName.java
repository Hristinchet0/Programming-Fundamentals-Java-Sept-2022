import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Georgi Georgiev, Ivan	Ivanov

        //A valid full name has the following characteristics:
        //o	It consists of two words.{} {}
        //o	Each word starts with a capital letter.[A-Z] [A-Z]
        //o	After the first letter, it only contains lowercase letters afterward. [A-Z][a-z] [A-Z][a-z]
        //o	Each of the two words should be at least two letters long.\\b[A-Z][a-z]+ [A-Z][a-z]+\\b
        //o	The two words are separated by a single space.
        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        Pattern pattern = Pattern.compile(regex); //шаблон

        Matcher matcher = pattern.matcher(text); //текстовете от text които отговарят на шаблона

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
