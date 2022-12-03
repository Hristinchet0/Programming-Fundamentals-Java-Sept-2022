import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
//        A valid number has the following characteristics:
//•	It starts with "+359". -> \\+359
//•	Then, it is followed by the area code (always 2). -> 2
//•	After that, it's followed by the number itself:
//        o	The number consists of 7 digits (separated into two groups of 3 and 4 digits, respectively). -> \d{3]\d{4}
//•	The different parts are separated by either a space or a hyphen ('-'). -> ([- ]) -> \+359([- ])2\1\\d{3}\1\\d{4}\b
        String regex = "\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);
        //print them on the console, separated by a comma and a space ", " без накрая
        List<String> phoneNumbers = new ArrayList<>();
        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }

        System.out.println(String.join(", ", phoneNumbers));
    }
}
