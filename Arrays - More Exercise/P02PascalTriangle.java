
import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());

        long[][] pascalArray = new long[numbers][];

        for (int i = 0; i < numbers; i++) {

            pascalArray[i] = new long[i + 1];

            for (int j = 0; j < i + 1; j++) {

                if (j > 0 && j < pascalArray[i].length - 1) {
                    pascalArray[i][j] = pascalArray[i - 1][j - 1] + pascalArray[i - 1][j];
                } else {
                    pascalArray[i][j] = 1;
                }
            }

            for (int j = 0; j < pascalArray[i].length; j++) {
                System.out.print(pascalArray[i][j] + " ");
            }
            System.out.println();
        }


    }
}
