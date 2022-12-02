import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();
        int remain = 0;
        int printable = 0;
        for (int i = firstNumber.length() - 1; i >= 0 ; i--) {
            int digit = Integer.parseInt(firstNumber.substring(i, i +1));
            int currentNumber = digit * secondNumber;
            currentNumber += remain;
            sb.append((currentNumber % 10));
            remain = currentNumber / 10;
        }

        if (remain != 0) {
            sb.append(remain);
        }
        boolean zero = true;
        for (int i = 0; i < sb.length(); i++) {
            if (Integer.parseInt(sb.substring(i, i + 1)) != 0) {
                zero = false;
            }
        }
        if (zero) {
            System.out.println(0);
        } else {
            StringBuilder output = new StringBuilder();
            boolean trailing = true;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (Integer.parseInt(sb.substring(i, i + 1)) == 0 && trailing) {

                } else {
                    trailing = false;
                    output.append(sb.charAt(i));
                }
            }
            System.out.println(output.toString());
        }
    }
}
