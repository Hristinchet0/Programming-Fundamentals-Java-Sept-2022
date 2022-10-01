import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= numbers; i++) {
            String input = scanner.nextLine();
            int index = input.indexOf(" ");

            long firstNumber = Long.parseLong(input.substring(0, index));
            long secondNumber = Long.parseLong(input.substring(index + 1));
            long sum = 0;
            long greater = 0;

            greater = Math.max(firstNumber, secondNumber);

            while (greater !=0) {
                sum += greater % 10;
                greater /= 10;
            }
            System.out.println(Math.abs(sum));

        }
    }
}
