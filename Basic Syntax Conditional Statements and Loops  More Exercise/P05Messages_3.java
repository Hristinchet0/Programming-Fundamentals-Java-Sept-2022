import java.util.Scanner;

public class P05Messages_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String result = "";
        for (int i = 1; i <= n ; i++ ) {
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);
            int lenght = input.length();
            int digit = number % 10;

            if (digit == 0) {
                result += " ";
                continue;
            }



            int offset = (digit - 2) * 3;

            if (digit == 8 || digit == 9)
                offset += 1;

            int index = 97 + (offset + lenght - 1);
            result += (char) index;
        }
        System.out.println(result);
    }
}