import java.util.Scanner;

public class P06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfLetters = Integer.parseInt(scanner.nextLine());

        for (char i = 'a'; i < 'a' + numbersOfLetters ; i++) {
            for (char j = 'a' ; j < 'a' + numbersOfLetters ; j++) {
                for (char k = 'a'; k < 'a' + numbersOfLetters ; k++) {
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
