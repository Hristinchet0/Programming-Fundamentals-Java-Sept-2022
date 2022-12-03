import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> carTypes = Arrays.stream(scanner.nextLine().split(">>")).collect(Collectors.toList());

        double totalTaxes = 0;
        for (int i = 0; i < carTypes.size(); i++) {
            String[] carType = carTypes.get(i).split(" ");
            String car = carType[0];
            int years = Integer.parseInt(carType[1]);
            int km = Integer.parseInt(carType[2]);

            double taxes = 0;

            if (car.equals("family")) {
                //taxes = taxForFamily - (years * 5) + ((km / 3000.0) * 12);
                taxes = km / 3000 * 12 + (50 - years * 5);
                totalTaxes = totalTaxes + taxes;
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", car, taxes);
            } else if (car.equals("heavyDuty")) {
                //taxes = taxForHeavyDuty - (years * 8) + ((km / 9000.0) * 14);
                taxes = km / 9000 * 14 + (80 - years * 8);
                totalTaxes = totalTaxes + taxes;
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", car, taxes);
            } else if (car.equals("sports")) {
                //taxes = taxForSports - (years * 9) + ((km / 2000.0) * 18);
                taxes = km / 2000 * 18 + (100 - years * 9);
                totalTaxes += taxes;
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", car, taxes);
            } else {
                System.out.println("Invalid car type.");
            }

        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTaxes);
    }
}
