import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        double courses = ((double) people / capacity);
        System.out.printf("%.0f", Math.ceil(courses));
    }
}
