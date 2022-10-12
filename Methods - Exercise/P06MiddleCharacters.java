import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacters(text);
    }

    public static void printMiddleCharacters (String text) {
        if (text.length() % 2 == 1) {
            int indexOfMiddleCharacter = text.length() / 2;
            System.out.println(text.charAt(indexOfMiddleCharacter));
        } else {
            int indexFristMiddleCharacter = text.length()  / 2 - 1;
            int indexSecondMiddleCharacter = text.length() / 2;

            System.out.println(text.charAt(indexFristMiddleCharacter) + "" + text.charAt(indexSecondMiddleCharacter));
        }
    }
}
