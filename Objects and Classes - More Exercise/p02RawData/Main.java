package p02RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            List<Tire> tireList = new ArrayList<>();
            for (int tires = 5; tires <= 12; tires += 2) {
                Tire currentTire = new Tire(Double.parseDouble(input[tires]), Integer.parseInt(input[tires + 1]));
                tireList.add(currentTire);
            }
            Car currentCar = new Car(model, engine, cargo, tireList);
            cars.add(currentCar);
        }

        String command = scanner.nextLine();
        
        switch (command) {
            case "fragile":
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);
                    Cargo cargo = car.getCargo();
                    String cargoType = cargo.getType();
                    if (cargoType.equals("fragile")) {
                        List<Tire> tireList = car.getTires();
                        for (int j = 0; j < tireList.size(); j++) {
                            Tire tire = tireList.get(j);
                            double pressure = tire.getPressure();
                            if (pressure < 1) {
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                }
                break;

            case "flamable":
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);
                    Cargo cargo = car.getCargo();
                    String cargoType = cargo.getType();
                    if (cargoType.equals("flamable")) {
                        Engine engine = car.getEngine();
                        int enginePower = engine.getPower();
                        if (enginePower > 250) {
                            System.out.println(car.getModel());

                        }
                    }
                }
                break;
        }
    }
}
