import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numbers = takeNumbersFromInput(input);
        List<String> notNumbers = takeNotNumbers(input);

        List<Integer> takeList = getTakeList(numbers);
        List<Integer> skipList = getSkipList(numbers);

        String message = takeMessage(notNumbers, takeList, skipList);
        System.out.println(message);

    }

    private static String takeMessage(List<String> nonNumbers, List<Integer> takeList, List<Integer> skipList) {

        StringBuilder message = new StringBuilder();
        int i = 0;
        int startIndex;
        int endIndex;
        int length = 0;

        while (i < takeList.size()) {
            startIndex = length;
            endIndex = length + takeList.get(i);

            while (startIndex < endIndex && startIndex <= nonNumbers.size() - 1) {
                message.append(nonNumbers.get(startIndex));
                startIndex++;
            }

            length = startIndex + skipList.get(i);
            i++;
        }

        return message.toString();
    }

    private static List<Integer> getSkipList(List<Integer> numbers) {

        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 != 0) {
                skipList.add(numbers.get(i));
            }
        }
        return skipList;
    }

    private static List<Integer> getTakeList(List<Integer> numbers) {

        List<Integer> takeList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            }
        }
        return takeList;
    }

    private static List<String> takeNotNumbers(String input) {

        input = input.replaceAll("\\d", "");

        return new ArrayList<>(Arrays.asList(input.split("")));
    }

    private static List<Integer> takeNumbersFromInput(String input) {

        List<Integer> numbersList = new ArrayList<>();
        String numbers = input.replaceAll("\\D", "");

        for (int i = 0; i < numbers.length(); i++) {
            numbersList.add(Character.digit(numbers.charAt(i), 10));
        }

        return numbersList;
    }
}
