import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //dd{separator}MMM{separator}yyyy".
        //Every valid date has the following characteristics:
        //•	Always starts with two digits, followed by a separator.
        //•	After that, it has one uppercase and two lowercase letters (e.g., Jan, Mar).
        //•	After that, it has a separator and exactly 4 digits (for the year).
        //•	The separator could be either of three things: a period ("."), a hyphen ("-") or a forward-slash ("/").
        //•	The separator needs to be the same for the whole date (e.g., 13.03.2016 is valid, 13.03/2016 is NOT).
        // Use a group back reference to check for this.

        String regex = "(?<day>\\d{2})(?<separator>[\\.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            //13/Jul/1928
            String day = matcher.group("day"); //"13"
            String month = matcher.group("month"); //"Jul"
            String year = matcher.group("year"); //"1928"
            //Day: 13, Month: Jul, Year: 1928
            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}