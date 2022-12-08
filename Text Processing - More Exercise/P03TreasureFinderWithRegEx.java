import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03TreasureFinderWithRegEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On the first line, you will receive a key (sequence of numbers).
        List<Integer> key = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int currentPosition = 0;
        //you will get a type of treasure and its coordinates.
        // The type will be between the symbol "&" and the coordinates will be between the symbols "<" and ">".
        String regex = "&(?<typeTreasure>.+)&[^<]*<(?<coordinate>.+)>";
        Pattern pattern = Pattern.compile(regex);
        //On the next few lines, until you receive "find", you will get lines of strings.
        String msg = scanner.nextLine();
        while (!msg.equals("find")) {
            int keyLength = key.size();
            int msgLength = msg.length();

            StringBuilder sb = new StringBuilder();

            for (int i = keyLength; i < msgLength; i++) {
                key.add(key.get(currentPosition));
                currentPosition++;
            }

            for (int i = 0; i < msgLength; i++) {
                sb.append((char) (msg.charAt(i) - key.get(i)));
            }

            Matcher matcher = pattern.matcher(sb.toString());

            if (matcher.find()) {
                String typeOfTreasure = matcher.group("typeTreasure");
                String coordinate = matcher.group("coordinate");
                System.out.printf("Found %s at %s%n", typeOfTreasure, coordinate);
            }


            msg = scanner.nextLine();
        }
    }
}
