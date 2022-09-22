
import java.util.Scanner;

public class P11MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        do {
            System.out.printf("%d X %d = %d\n", n1, n2, n1 * n2);
            n2++;
        } while (n2 <= 10);
    }
}
