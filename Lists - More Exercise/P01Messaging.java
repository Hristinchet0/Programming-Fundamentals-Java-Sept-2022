import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersInList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<String> messageInList = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        String secretMessage = sumOfDigitsAtIndex(numbersInList, messageInList);
        System.out.println(secretMessage);

    }


    public static int findIndex(List<String> messageList, int sum) {

        int index;
        if (sum > messageList.size()) {
            index = sum % messageList.size();
        } else {
            index = sum;
        }

        return index;
    }

    public static String sumOfDigitsAtIndex(List<Integer> numbers, List<String> message) {

        StringBuilder secretMessage = new StringBuilder();
        for (Integer number : numbers) {

            int sum = 0;
            int currentNum = number;
            while (currentNum > 0) {

                int digit = currentNum % 10;
                sum += digit;
                currentNum = currentNum / 10;
            }
            int index = findIndex(message, sum);
            secretMessage.append(findLetter(message, index));
        }

        return secretMessage.toString();
    }

    public static String findLetter(List<String> messageList, int index) {

        String letter = messageList.get(index);
        messageList.remove(index);
        return letter;
    }
}