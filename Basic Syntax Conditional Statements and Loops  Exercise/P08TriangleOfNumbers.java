import java.util.Scanner;

public class P08TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row <= number; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print(row +" ");
            }
            System.out.println();
        }
    }
}
