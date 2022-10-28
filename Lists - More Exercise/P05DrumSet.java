import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        List<Integer> initialDrumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        getGabsyDrumSet(scanner, budget, initialDrumSet);

    }

    public static void getGabsyDrumSet(Scanner scanner, double budget, List<Integer> initialDrumSet) {

        List<Integer> drumSet = new ArrayList<>(initialDrumSet);
        String input;

        while (!(input = scanner.nextLine()).equals("Hit it again, Gabsy!")) {

            int power = Integer.parseInt(input);

            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, (drumSet.get(i) - power));
                if (drumSet.get(i) <= 0 && budget >= initialDrumSet.get(i) * 3) {
                    drumSet.set(i, initialDrumSet.get(i));
                    budget -= initialDrumSet.get(i) * 3;
                } else if (drumSet.get(i) <= 0 && budget < initialDrumSet.get(i) * 3) {
                    drumSet.remove(drumSet.get(i));
                    initialDrumSet.remove(initialDrumSet.get(i));
                    i--;
                }
            }
        }

        for (int num : drumSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", budget);
    }
}
