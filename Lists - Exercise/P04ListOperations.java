import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if (command.contains("Add")) {
                //•	Add {number} - add number at the end
                int numberToAdd = Integer.parseInt(command.split("\\s+")[1]);
                numbers.add(numberToAdd);

            } else if (command.contains("Insert")) {
                //•	Insert {number} {index} - insert number at given index
                int numberToInsert = Integer.parseInt(command.split("\\s+")[1]);
                int index = Integer.parseInt(command.split("\\s+")[2]);
                if (isValidIndex(index, numbers)) {
                    numbers.add(index, numberToInsert);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Remove")) {
                //•	Remove {index} - remove that index
                int indexToRemove = Integer.parseInt(command.split("\\s+")[1]);
                if (isValidIndex(indexToRemove, numbers)) {
                    numbers.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {
                //•	Shift left {count} - first number becomes last 'count' times
                int countShiftLeft = Integer.parseInt(command.split("\\s+")[2]);
                for (int i = 1; i <= countShiftLeft; i++) {
                    int firstNumber = numbers.get(0);
                    numbers.remove(0);
                    numbers.add(firstNumber);
                }

            } else if (command.contains("Shift right")) {
                //•	Shift right {count} - last number becomes first 'count' times
                int countShiftRight = Integer.parseInt(command.split("\\s+")[2]);
                for (int i = 1; i <= countShiftRight; i++) {
                    int lastNumber = numbers.get(numbers.size() - 1);
                    numbers.remove(numbers.size() - 1);
                    numbers.add(0, lastNumber);
                }

            }

            command = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }

    public static boolean isValidIndex(int index, List<Integer> numbers) {
        return index >= 0 && index <= numbers.size() - 1;
    }
}
