import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double carOne = firstCarTime(numbers);
        double carTwo = secondCarTime(numbers);
        printWinnerCar(carOne, carTwo);
    }

    private static double firstCarTime(List<Integer> numbers) {

        double carOneTime = 0;
        int carOneCount = 0;

        while (carOneCount < numbers.size() / 2) {
            if (numbers.get(carOneCount) == 0) {
                carOneTime *= 0.8;
            } else {
                carOneTime += numbers.get(carOneCount);
            }
            carOneCount++;
        }
        return carOneTime;
    }
    private static double secondCarTime(List<Integer> numbers) {

        double carTwoTime = 0;
        int carTwoCount = numbers.size() - 1;


        while (carTwoCount > numbers.size() / 2) {
            if (numbers.get(carTwoCount) == 0) {
                carTwoTime *= 0.8;
            } else {
                carTwoTime += numbers.get(carTwoCount);
            }
            carTwoCount--;
        }
        return carTwoTime;
    }
    private static void printWinnerCar(double carOneTime, double carTwoTime) {
        if (carTwoTime > carOneTime) {
            System.out.printf("The winner is right with total time: %.1f", carTwoTime);
        } else {
            System.out.printf("The winner is left with total time: %.1f", carOneTime);
        }
    }
}
