import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yeld = Integer.parseInt(scanner.nextLine());
        int produced = 0;
        int days = 0;

        if (yeld >=  100) {
            while (yeld >= 100) {
                produced += yeld;
                yeld -= 10;
                days++;
            }
            produced -= (days + 1) * 26;
            System.out.println(days);
            System.out.println(produced);
        } else {
            System.out.println(days);
            System.out.println(produced);

        }
    }
}
