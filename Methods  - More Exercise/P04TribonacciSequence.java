import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        printTribonacci(num);

    }
    public static void printTribonacci (int num) {
        int[] sequence = {1 , 1 , 2 , 4};
        for (int i = 4; i < num; i++) {
            int[] array = new int[sequence.length + 1];
            System.arraycopy(sequence, 0, array, 0, sequence.length);
            array[i] = sequence[i - 3] + sequence[i - 2] + sequence[i - 1];
            sequence = array;
        }
        for (int i = 0; i < num; i++) {
            System.out.print(sequence[i] + " ");
        }
    }
}
