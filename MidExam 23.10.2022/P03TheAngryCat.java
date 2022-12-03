import java.util.Arrays;
import java.util.Scanner;

public class P03TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] priceRatings = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int entryPoint = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();

        int compareValue = priceRatings[entryPoint];

        int leftSum = 0;
        int rightSum = 0;

        if (typeOfItems.equals("cheap")) {
            for (int i = entryPoint - 1; i >= 0; i--) {
                if (priceRatings[i] < compareValue) {
                    leftSum += priceRatings[i];
                }
            }
            for (int j = entryPoint + 1; j <= priceRatings.length - 1; j++) {
                if (priceRatings[j] < compareValue) {
                    rightSum += priceRatings[j];
                }
            }
        }
        if (typeOfItems.equals("expensive")) {
            for (int i = entryPoint - 1; i >= 0; i--) {
                if (priceRatings[i] >= compareValue) {
                    leftSum += priceRatings[i];
                }
            }
            for (int j = entryPoint + 1; j <= priceRatings.length - 1; j++) {
                if (priceRatings[j] >= compareValue) {
                    rightSum += priceRatings[j];
                }
            }
        }

        if (leftSum >= rightSum) {
            System.out.printf("Left - %d", leftSum);
        } else {
            System.out.printf("Right - %d", rightSum);
        }
    }
}
