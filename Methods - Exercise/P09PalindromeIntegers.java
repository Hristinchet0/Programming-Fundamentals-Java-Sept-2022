import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        while (!number.equals("END")) {
            if (!isPalindrom(number)) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            number = scanner.nextLine();
        }

    }
    private static boolean isPalindrom (String number) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = number.length() - 1; i >= 0 ; i--) {
            reversedString.append(number.charAt(i));
        }
        return number.equals(reversedString.toString());
    }
}
