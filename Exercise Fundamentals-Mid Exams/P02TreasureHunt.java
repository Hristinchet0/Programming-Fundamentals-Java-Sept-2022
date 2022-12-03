import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] treasureChest = scanner.nextLine().split("\\|");

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandParts = command.split(" ");

            switch (commandParts[0]) {
                case "Loot":
                    for (int i = 1; i < commandParts.length; i++) {
                        boolean alreadyContained = false;
                        for (String s : treasureChest) {
                            if (commandParts[i].equals(s)) {
                                alreadyContained = true;
                                break;
                            }
                        }
                        if (!alreadyContained) {
                            String newChest = commandParts[i] + " " + String.join(" ", treasureChest);
                            treasureChest = newChest.split(" ");
                        }
                    }
                    break;
                case "Drop":
                    int position = Integer.parseInt(commandParts[1]);

                    if (position <= treasureChest.length - 1 && position >= 0) {
                        String dropItem = treasureChest[position];
                        if (treasureChest.length - 1 - position >= 0)
                            System.arraycopy(treasureChest, position + 1, treasureChest, position, treasureChest.length - 1 - position);
                        treasureChest[treasureChest.length - 1] = dropItem;
                    }else {
                        break;
                    }
                    break;
                case "Steal":
                    int numberOfStealingItems = Integer.parseInt(commandParts[1]);

                    if (numberOfStealingItems >= 0 && numberOfStealingItems < treasureChest.length) {
                        for (int i = 0; i < numberOfStealingItems; i++) {
                            System.out.print(treasureChest[treasureChest.length - numberOfStealingItems + i]);

                            if (i != numberOfStealingItems - 1) {
                                System.out.print(", ");
                            }
                        }
                        String[] tempChest = new String[treasureChest.length - numberOfStealingItems];

                        System.arraycopy(treasureChest, 0, tempChest, 0, tempChest.length);
                        treasureChest = tempChest;

                    } else if (numberOfStealingItems >= 0) {
                        for (int i = 0; i < treasureChest.length; i++) {
                            System.out.print(treasureChest[i]);
                            if (i != treasureChest.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        treasureChest = new String[0];
                    }
                    System.out.println();
                    break;

            }
            command = scanner.nextLine();
        }

        int charCounter = printTreasures(treasureChest);

        averageTreasureGain(treasureChest, charCounter);
    }

    private static int printTreasures(String[] treasureChest) {
        String treasureCount = String.join("", treasureChest);
        int charCounter = 0;

        for (int i = 0; i < treasureCount.length(); i++) {
            charCounter++;
        }
        return charCounter;
    }

    private static void averageTreasureGain(String[] treasureChest, int charCounter) {
        double averageTreasure = (1.0 * charCounter) / treasureChest.length;
        if (charCounter > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
