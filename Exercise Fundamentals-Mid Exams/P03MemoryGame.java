import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequenceNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        int counter = 0;
        int successCounter = 0;

        while (!input.equals("end")) {

            int left = Integer.parseInt(input.split(" ")[0]);
            int right = Integer.parseInt(input.split(" ")[1]);
            counter++;

            if (!isValid(sequenceNumbers, left, right)) {
                System.out.println("Invalid input! Adding additional elements to the board");
                sequenceNumbers.add(sequenceNumbers.size() / 2, -counter + "a");
                sequenceNumbers.add(sequenceNumbers.size() / 2, -counter + "a");
                input = scanner.nextLine();
                continue;
            }

            if (isValid(sequenceNumbers, left, right)) {
                if (sequenceNumbers.get(left).equals(sequenceNumbers.get(right))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequenceNumbers.get(left));
                    if (left < right) {
                        sequenceNumbers.remove(right);
                        sequenceNumbers.remove(left);
                    } else {
                        sequenceNumbers.remove(left);
                        sequenceNumbers.remove(right);
                    }
                    successCounter++;
                } else {
                    System.out.println("Try again!");
                }
            }
            if (isEmpty(sequenceNumbers)) {
                System.out.printf("You have won in %d turns!", successCounter);
                break;
            }
            input = scanner.nextLine();
        }

        if (!isEmpty(sequenceNumbers)) {
            System.out.println("Sorry you lose :(");
            for (int i = 0; i < sequenceNumbers.size(); i++) {
                String elements = sequenceNumbers.get(i);
                System.out.print(elements + " ");
            }
        }
    }
    private static boolean isEmpty(List<String> sequenceNumbers) {
        return sequenceNumbers.isEmpty();
    }

    public static boolean isValid(List<String> sequenceNumbers, int left, int right) {
        return (left >= 0 && left <= sequenceNumbers.size() - 1)
                && (right >= 0 && right <= sequenceNumbers.size() - 1)
                && (left != right);
    }
}
