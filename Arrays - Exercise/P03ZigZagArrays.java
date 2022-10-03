import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        String[] firstArray = new String[rows];
        String[] secondArray = new String[rows];

        //четен ред -> първото число отива във втория масив,
        //четен ред -> второто число отива в първия масив

        //нечетен ред -> първото число в първия масив,
        //нечетен ред -> второто число във втория масив

        for (int row = 1; row <= rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            String firstNumber = numbers[0];
            String secondNumber = numbers[1];

            if (row % 2 == 0) {
                secondArray[row - 1] = firstNumber;
                firstArray[row - 1] = secondNumber;
            } else {
                firstArray[row - 1] = firstNumber;
                secondArray[row - 1] = secondNumber;
            }
        }
        //отпечатване на масив
        //1. for цикъл по индекс
        //2. foreach по елементи
        //3. Само за масив от стринг String.join !!!!!

        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ", secondArray));
    }
}
