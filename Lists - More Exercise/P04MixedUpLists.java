import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondNumberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> middleElements = getMiddleElements(firstNumberList, secondNumberList);
        List<Integer> inBetweenMiddleElements = getBetweenTheMiddleElements(firstNumberList, secondNumberList);

        printInBetweenMiddleElements(inBetweenMiddleElements, middleElements);
    }

    private static void printInBetweenMiddleElements(List<Integer> inBetweenMiddleElements, List<Integer> middleElements) {

        int middleHigh = Math.max(middleElements.get(0), middleElements.get(1));
        int middleMin = Math.min(middleElements.get(0), middleElements.get(1));
        for (int num : inBetweenMiddleElements) {
            if (num > middleMin && num < middleHigh) {
                System.out.print(num + " ");
            }
        }
    }

    public static List<Integer> getBetweenTheMiddleElements(List<Integer> firstNumberList, List<Integer> secondNumberList) {

        List<Integer> betweenTheMiddleElements = new ArrayList<>();
        List<Integer> merge = Stream.of(firstNumberList, secondNumberList).flatMap(Collection::stream).toList();

        for (int i = 0; i < merge.size(); i++) {

            if (i < merge.size() / 2 - 1) {
                betweenTheMiddleElements.add(merge.get(i));
                betweenTheMiddleElements.add(merge.get(merge.size() - 1 - i));
            } else {
                break;
            }
        }

        Collections.sort(betweenTheMiddleElements);
        return betweenTheMiddleElements;
    }

    private static List<Integer> getMiddleElements(List<Integer> firstNumberList, List<Integer> secondNumberList) {

        List<Integer> merge = Stream.of(firstNumberList, secondNumberList).flatMap(Collection::stream).toList();
        List<Integer> middleElements = new ArrayList<>();
        middleElements.add(merge.get(merge.size() / 2 - 1));
        middleElements.add(merge.get(merge.size() / 2));

        return middleElements;
    }
}
