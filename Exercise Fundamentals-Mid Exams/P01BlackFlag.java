import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0;

        for (int index = 1; index <= days ; index++) {
            totalPlunder += dailyPlunder;

            if (index % 3 == 0) {
                totalPlunder += dailyPlunder / 2.0;
            }
            if (index % 5 == 0) {
                totalPlunder -= totalPlunder * 0.3;
            }
        }
        printPlunder(expectedPlunder, totalPlunder);
    }

    public static void printPlunder(double expectedPlunder, double totalPlunder) {
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", totalPlunder / expectedPlunder * 100);
        }
    }
}
