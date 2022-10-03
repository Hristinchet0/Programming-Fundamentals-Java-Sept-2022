import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < values.length; i++) {
            boolean isTopBigger = true;
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] <= values[j]) {
                    isTopBigger = false;
                }
            }
            if (isTopBigger) {
                System.out.print(values[i] + " ");
            }
        }
    }
}
