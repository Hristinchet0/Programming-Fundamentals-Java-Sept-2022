import java.math.BigInteger;
import java.util.Scanner;

public class P05MultiplyBigNumberWithBigIntegerClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        BigInteger secondNumber = new BigInteger(scanner.nextLine());

        //* -> multiply
        System.out.println(firstNumber.multiply(secondNumber));
        // / -> divide
        //System.out.println(firstNumber.divide(secondNumber));
        // + -> add
        //System.out.println(firstNumber.add(secondNumber));
        // - -> subtract
        //System.out.println(firstNumber.subtract(secondNumber));
    }
}
