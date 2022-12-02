import java.util.*;
import java.util.stream.Collectors;


public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("End")) {
            int newIndex = Integer.parseInt(input);
            if (newIndex < 0 || newIndex > targets.size()) {
                input = scanner.nextLine();
                continue;
            }
            if (newIndex <= targets.size() - 1) {
                if (targets.get(newIndex) != -1) {
                    int currentTarget = targets.get(newIndex);
                    targets.set(newIndex, -1);
                    count++;

                    for (int i = 0; i < targets.size(); i++) {
                        if (targets.get(i) > currentTarget && targets.get(i) != -1) {
                            targets.set(i, targets.get(i) - currentTarget);
                        } else if (targets.get(i) <= currentTarget && targets.get(i) != -1) {
                            targets.set(i, targets.get(i) + currentTarget);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        for (Integer target : targets) {
            System.out.print(target + " ");
        }
    }
}