package p03CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        //On the first line, you will read a number N which will specify how many lines of engines
        // you will receive, on each of the next N lines,
        // you will receive information about an Engine in the following format
        // "{Model} {Power} {Displacement} {Efficiency}".
        //{Displacement} {Efficiency} are optional
        for (int i = 0; i < numberEngines; i++) {
            String[] engineLine = scanner.nextLine().split(" ");
            //V4-33 140 28 B
            //V8-101 220 50
            //DSL-10 280 B
            //DSL-13 305 55 A+
            String engineModel = engineLine[0];
            int power = Integer.parseInt(engineLine[1]);
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineLine.length == 4) {
                displacement = engineLine [2];
                efficiency = engineLine[3];
            }

            if (engineLine.length == 3) {
                if (engineLine[2].contains("1") || engineLine[2].contains("2") || engineLine[2].contains("3") || engineLine[2].contains("4")
                        || engineLine[2].contains("5") || engineLine[2].contains("6") || engineLine[2].contains("7") || engineLine[2].contains("8")
                        || engineLine[2].contains("9") || engineLine[2].contains("0")) {
                    displacement = String.valueOf(Integer.parseInt(engineLine[2]));
                } else {
                    efficiency = engineLine[2];
                }
            }

            Engine engine = new Engine(engineModel, power, displacement, efficiency);
            engineList.add(engine);

        }

        int numberCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        // on the next line, you will receive a number M – specifying the number of Cars that will follow,
        // on each of the next M lines, information about a Car will follow in the
        // following format "{Model} {Engine} {Weight} {Color}" ... A Car's weight and color are optional
        //where the engine in the format will be the model of an existing Engine.
        for (int i = 0; i < numberCars; i++) {
            String[] carLine = scanner.nextLine().split(" ");
            String model = carLine[0];
            String engineCar = carLine[1];
            String weight = "n/a";
            String colour = "n/a";
            //FordFocus V4-33 1300 Silver
            //FordMustang V8-101
            //VolkswagenGolf V4-33 Orange
            if (carLine.length == 4) {
                weight = carLine [2];
                colour = carLine[3];
            }
            if (carLine.length == 3) {
                if (carLine[2].contains("1") || carLine[2].contains("2") || carLine[2].contains("3") || carLine[2].contains("4")
                        || carLine[2].contains("5") || carLine[2].contains("6") || carLine[2].contains("7") || carLine[2].contains("8")
                        || carLine[2].contains("9") || carLine[2].contains("0")) {
                    weight = String.valueOf(Integer.parseInt(carLine[2]));
                } else {
                    colour = carLine[2];
                }
            }

            Car car = new Car(model, engineCar, weight, colour);
            carList.add(car);

        }

    }
}
