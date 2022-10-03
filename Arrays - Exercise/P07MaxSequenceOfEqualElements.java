import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int counter = 0;
        int theLongest = 0;
        int index = 0;
        String number = "";

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                counter++;
                if (counter > theLongest) {
                    theLongest = counter;
                    index = i;
                    number = String.valueOf(numbers[i]);
                }
            } else {
                counter = 0;
            }
        }

        for (int i = 0; i <= theLongest; i++) {
            System.out.print(number + " ");
        }

    }
}
