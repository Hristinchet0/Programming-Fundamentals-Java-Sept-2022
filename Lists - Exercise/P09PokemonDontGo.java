import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sumRemoved = 0;

        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index <= numbers.size() - 1) {
                int removedElement = numbers.get(index);
                sumRemoved += removedElement;
                numbers.remove(index);

                modifyList(numbers, removedElement);
            } else if (index < 0) {
                int firstElement = numbers.get(0);
                numbers.remove(0);
                sumRemoved += firstElement;
                int lastElement = numbers.get(numbers.size() - 1);
                numbers.add(0, lastElement);

                modifyList(numbers, firstElement);


            } else if (index > numbers.size() - 1) {
                int lastElement = numbers.get(numbers.size() - 1);
                sumRemoved += lastElement;
                numbers.remove(numbers.size() - 1);
                int firstElement = numbers.get(0);
                numbers.add(firstElement);
                modifyList(numbers,lastElement);


            }
        }
        System.out.println(sumRemoved);
    }

    private static void modifyList(List<Integer> numbers, int removedElement) {
        for (int indexInList = 0; indexInList <= numbers.size() - 1; indexInList++) {
            int currentNumber = numbers.get(indexInList);
            if (currentNumber <= removedElement) {
                currentNumber += removedElement;
            } else {
                currentNumber -= removedElement;
            }

            numbers.set(indexInList, currentNumber);
        }
    }
}
