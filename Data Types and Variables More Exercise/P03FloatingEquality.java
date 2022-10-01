import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1 = Double.parseDouble(scanner.nextLine());
        double number2 = Double.parseDouble(scanner.nextLine());

        double eps = 0.000001;

        boolean isEqual = Math.abs(number1 - number2) < eps;

        if (isEqual) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
