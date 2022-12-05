import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String carInfo = scanner.nextLine();
            //"{car}|{mileage}|{fuel}"
            String car = carInfo.split("\\|")[0];
            int mileage = Integer.parseInt(carInfo.split("\\|")[1]);
            int fuel = Integer.parseInt(carInfo.split("\\|")[2]);
            carMileage.put(car, mileage);
            carFuel.put(car, fuel);
        }

        String commands = scanner.nextLine();

        while (!commands.equals("Stop")) {

            if (commands.contains("Drive")) {
                //•	"Drive : {car} : {distance} : {fuel}":
                String car = commands.split("\\s+:\\s+")[1];
                int givenDistance = Integer.parseInt(commands.split("\\s+:\\s+")[2]);
                int givenFuel = Integer.parseInt(commands.split("\\s+:\\s+")[3]);
                if (carFuel.get(car) < givenFuel) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    int currentFuel = carFuel.get(car) - givenFuel;
                    int currentMileage = carMileage.get(car) + givenDistance;
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, givenDistance, givenFuel);
                    carFuel.put(car, currentFuel);
                    carMileage.put(car, currentMileage);
                }
                if (carMileage.get(car) >= 100000) {
                    System.out.printf("Time to sell the %s!%n", car);
                    carMileage.remove(car);
                    carFuel.remove(car);
                }

            } else if (commands.contains("Refuel")) {
                //•	"Refuel : {car} : {fuel}":
                String car = commands.split("\\s+:\\s+")[1];
                int givenFuel = Integer.parseInt(commands.split("\\s+:\\s+")[2]);
                int fuelInCar = carFuel.get(car);
                int currentFuel = fuelInCar + givenFuel;
                if (currentFuel > 75) {
                    currentFuel = 75;
                }

                carFuel.put(car, currentFuel);
                System.out.printf("%s refueled with %d liters%n", car, currentFuel - fuelInCar);


            } else if (commands.contains("Revert")) {
                //•	"Revert : {car} : {kilometers}":
                String car = commands.split("\\s+:\\s+")[1];
                int givenDistance = Integer.parseInt(commands.split("\\s+:\\s+")[2]);
                int currentMileage = carMileage.get(car) - givenDistance;
                carMileage.put(car, currentMileage);
                if (carMileage.get(car) < 10000) {
                    currentMileage = 10000;
                    carMileage.put(car, currentMileage);
                } else {
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, givenDistance);
                }

            }

            commands = scanner.nextLine();
        }
        //Upon receiving the "Stop" command, you need to print all cars in your possession in the following format:
        //"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."

        carMileage.entrySet()
                .forEach(entry -> {
                    String car = entry.getKey();
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, entry.getValue(), carFuel.get(car));
                });
    }
}
