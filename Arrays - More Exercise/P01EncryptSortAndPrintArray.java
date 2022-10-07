import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[numberOfStrings];

       // vowels = aeiouAEIOU

        for (int i = 0; i < numberOfStrings; i++) {
            String sequencOfStrings = scanner.nextLine();
            int lengthOfString =sequencOfStrings.length();
            int sum = 0;

            for (int j = 0; j < sequencOfStrings.length(); j++) {
                char currentChar = sequencOfStrings.charAt(j);

                switch (currentChar) {
                    case 'a':
                    case 'A':
                    case 'e':
                    case 'E':
                    case 'i':
                    case 'I':
                    case 'o':
                    case 'O':
                    case 'u':
                    case 'U':
                        sum += currentChar * lengthOfString;
                        break;
                    default:
                        sum += currentChar / lengthOfString;
                        break;
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int print : numbers) {
            System.out.println(print);
        }
    }
}
