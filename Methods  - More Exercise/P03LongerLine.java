import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double lengthForstLine = lengthOfLine(x1, y1, x2, y2);
        double lengthSecondLine = lengthOfLine(x3, y3, x4, y4);

        if (lengthForstLine >= lengthSecondLine) {
            closestPointToCenter(x1, y1, x2, y2);
        } else {
            closestPointToCenter(x3, y3, x4, y4);
        }

    }
    public static double lengthOfLine(double x1, double y1, double x2, double y2) {
        double result = Math.pow((x2 - x1), 2) + Math.pow((y1 - y2), 2);
        result = Math.sqrt(result);
        return result;
    }

    public static void closestPointToCenter(double x1, double y1, double x2, double y2) {
        double p = (x1 * x1) + (y1 * y1);
        double p2 = (x2 * x2) + (y2 * y2);
        //(4, -3)(-5, -5)
        if (p <= p2) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
        }
    }
}
