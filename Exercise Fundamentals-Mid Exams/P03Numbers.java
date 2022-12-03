import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequenceNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> top5Numbers = new ArrayList<>();

        int sum = 0;
        double averageSum = 0;

        for (int i = 0; i < sequenceNumbers.size(); i++) {
            sum += sequenceNumbers.get(i);
        }

        averageSum = 1.00 * sum / sequenceNumbers.size();
        for (int j = 0; j < sequenceNumbers.size(); j++) {
            if (averageSum < sequenceNumbers.get(j)) {
                top5Numbers.add(sequenceNumbers.get(j));
            }
        }

        averageSum = 1.00 * sum / sequenceNumbers.size();


        Collections.sort(top5Numbers);
        Collections.reverse(top5Numbers);

        if (top5Numbers.size() < 1) {
            System.out.println("No");
        }
        if (top5Numbers.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(top5Numbers.get(i) + " ");
            }
        } else {
            for (int i = 0; i < top5Numbers.size(); i++) {
                int numberTop5 = top5Numbers.get(i);
                System.out.print(numberTop5 + " ");
            }
        }
    }
}
