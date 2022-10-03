import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());

        int[] peopleInWagon = new int[wagons];
        int sum = 0;

        for (int wagon = 0; wagon < wagons; wagon++) {
            peopleInWagon[wagon] = Integer.parseInt(scanner.nextLine());

            System.out.print(peopleInWagon[wagon] + " ");

            sum += peopleInWagon[wagon];
        }
        System.out.println();
        System.out.println(sum);

    }
}
