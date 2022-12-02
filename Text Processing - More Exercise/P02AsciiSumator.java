import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //In the first line, you will get a character.
        char firstLine = scanner.nextLine().charAt(0);
        // In the second line, you get another character.
        char secondLine = scanner.nextLine().charAt(0);
        // On the last line, you get a random string.
        String textLine = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < textLine.length(); i++) {
            int currentSymbol = textLine.charAt(i);
            //Find all the characters between the two given and print their ASCII sum.
            if(currentSymbol > firstLine && currentSymbol < secondLine) {
                sum += currentSymbol;
            }
        }
        System.out.println(sum);
    }
}
