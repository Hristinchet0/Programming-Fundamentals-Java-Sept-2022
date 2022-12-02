import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetSequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {

                for (int i = 0; i < targetSequence.size(); i++) {
                    int currentValue = targetSequence.get(i);

                    if (i == 0 || i == targetSequence.size()) {
                        System.out.print(currentValue);
                    } else {
                        System.out.print("|" + currentValue);
                    }
                }
                break;
            }

            List<String> commandInput = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

            String command = commandInput.get(0);
            int index = Integer.parseInt(commandInput.get(1));
            int value = Integer.parseInt(commandInput.get(2));

            switch (command) {
                case "Shoot":
                    if (0 <= index && index < targetSequence.size()) {
                        targetSequence.set(index, targetSequence.get(index) - value);

                        if (targetSequence.get(index) <= 0) {
                            targetSequence.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (0 <= index && index < targetSequence.size()) {
                        targetSequence.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int startIndex = index - value;
                    int endIndex = index + value;

                    if (0 <= startIndex && endIndex < targetSequence.size() - 1) {
                        //list.subList(start, end).clear(); Изтрива в диапазона от startIndex до (endIndex  + 1) включително
                        targetSequence.subList(startIndex, (endIndex + 1)).clear();


                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
        }
    }
}
