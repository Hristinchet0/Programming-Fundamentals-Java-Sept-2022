import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static long[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        numbers = new long[num + 2];
        numbers[1] = 1;
        numbers[2] = 1;

        long result = fibonacci(num);
        System.out.println(result);
        scanner.close();

    }

    public static long fibonacci(int n) {
        if (0 == numbers[n]) {
            numbers[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return numbers[n];
    }
}
