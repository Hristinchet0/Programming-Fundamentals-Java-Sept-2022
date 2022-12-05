import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String places = scanner.nextLine();
        //=Hawai=/Cyprus/=Invalid/invalid==i5valid=/I5valid/=i=

        String regex = "(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);

        //Destinations: Hawai, Cyprus
        //Travel Points: 11
        int travelPoints = 0;
        List<String> destinationsFound = new ArrayList<>();

        while (matcher.find()) {
            String currentDestination = matcher.group("destination");
            travelPoints += currentDestination.length();
            destinationsFound.add(currentDestination);
        }

        String destinations = String.join(", ", destinationsFound);
        System.out.printf("Destinations: %s%n", destinations);
        System.out.printf("Travel Points: %d", travelPoints);


    }
}
