import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);

        String result = String.format("%c%c%c",firstChar,secondChar,thirdChar);

        System.out.println(result);
    }
}
