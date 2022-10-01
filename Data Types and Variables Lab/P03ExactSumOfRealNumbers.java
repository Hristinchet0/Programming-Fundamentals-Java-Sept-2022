import java.math.BigDecimal;
import java.util.Scanner;

public class P03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal sum = new BigDecimal(0);
        for (int i = 1; i <= n ; i++) {
            BigDecimal currentSum = new BigDecimal(scanner.nextLine());

            sum = sum.add(currentSum);
        }
        System.out.println(sum);
    }
}
