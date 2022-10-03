import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isFound = false;

        for (int i = 0; i < values.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += values[j];
            }

            int rightSum = 0;
            for (int j = values.length - 1; j > i ; j--) {
                rightSum += values[j];
            }

            if (leftSum == rightSum && !isFound) {
                System.out.println(i);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}
