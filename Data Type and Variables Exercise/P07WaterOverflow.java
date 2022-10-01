import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countLitersPoured = Integer.parseInt(scanner.nextLine());
        int capacity = 255;

        int totalPouredWater = 0;

        for (int i = 1; i <= countLitersPoured; i++) {
            int quantitiesLiters = Integer.parseInt(scanner.nextLine());

            if (totalPouredWater + quantitiesLiters > capacity) {
                System.out.println("Insufficient capacity!");
            } else {
                totalPouredWater += quantitiesLiters;
            }

        }
        System.out.println(totalPouredWater);
    }
}
