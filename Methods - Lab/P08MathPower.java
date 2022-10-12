import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numIntup = Double.parseDouble(scanner.nextLine());
        double powerIntup = Double.parseDouble(scanner.nextLine());

        double result = mathPower(numIntup, powerIntup);

        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(result));

    }

    public static double mathPower (double num, double power) {
        // 2  на 4 степен (2^3) = 2 * 2 * 2 * 2;
        double result = 1; //! равно на 1, защото ако е 0 не можем да умножаваме на 0
        for (int i = 1; i <= power; i++) {
            result = result * num;
        }

        return result;
    }
}
