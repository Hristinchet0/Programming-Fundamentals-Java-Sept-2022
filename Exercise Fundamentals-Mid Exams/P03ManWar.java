import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03ManWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipStatus = Arrays.stream(scanner.nextLine().split(">+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShipStatus = Arrays.stream(scanner.nextLine().split(">+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int maxHealth = Integer.parseInt(scanner.nextLine());
        boolean isSunken = false;

        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            String[] commands = command.split("\\s+");

            if (commands[0].equals("Fire")) {
                int index = Integer.parseInt(commands[1]);
                int damage = Integer.parseInt(commands[2]);
                if (index >= 0 && index < pirateShipStatus.size()) {
                    int afterFire = warShipStatus.get(index);
                    afterFire -= damage;
                    if (afterFire <= 0) {
                        System.out.print("You won! The enemy ship has sunken.");
                        isSunken = true;
                        return;
                    } else {
                        warShipStatus.remove(index);
                        warShipStatus.add(index, afterFire);
                    }
                }
            } else if (commands[0].equals("Defend")) {
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                int damage = Integer.parseInt(commands[3]);
                if (startIndex >= 0 && startIndex < pirateShipStatus.size() && endIndex >= 0 && endIndex < pirateShipStatus.size() && damage >= 0) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        int result = pirateShipStatus.get(i) - damage;
                        if (result <= 0) {
                            System.out.print("You lost! The pirate ship has sunken.");
                            isSunken = true;
                            return;
                        } else {
                            pirateShipStatus.remove(pirateShipStatus.get(i));
                            pirateShipStatus.add(startIndex, result);
                            startIndex++;
                        }
                    }
                }
            } else if (commands[0].equals("Repair")) {
                int index = Integer.parseInt(commands[1]);
                int health = Integer.parseInt(commands[2]);
                if (index >= 0 && index < pirateShipStatus.size() && health >= 0) {
                    if (health >= maxHealth) {
                        health = maxHealth;
                        pirateShipStatus.remove(index);
                        pirateShipStatus.add(index, health);
                    } else {
                        int num = pirateShipStatus.get(index);
                        pirateShipStatus.remove(index);
                        pirateShipStatus.add(index, health + num);
                    }
                }
            } else if (commands[0].equals("Status")) {
                int count = 0;
                double percentage = maxHealth - (maxHealth * 0.8);
                for (int index : pirateShipStatus) {
                    if (percentage > index) {
                        count++;
                    }
                }
                System.out.printf("%d sections need repair.%n", count);
            }

            command = scanner.nextLine();

        }


        printResult(pirateShipStatus, warShipStatus, isSunken);
    }

    private static void printResult(List<Integer> pirateShipStatus, List<Integer> warShipStatus, boolean isSunken) {
        int pirateResult = 0;
        int warResult = 0;

        if (!isSunken) {

            for (Integer shipStatus : pirateShipStatus) {
                pirateResult += shipStatus;
            }

            System.out.printf("Pirate ship status: %d%n", pirateResult);

            for (Integer shipStatus : warShipStatus) {
                warResult += shipStatus;
            }
            System.out.printf("Warship status: %d", warResult);
        }
    }
}
