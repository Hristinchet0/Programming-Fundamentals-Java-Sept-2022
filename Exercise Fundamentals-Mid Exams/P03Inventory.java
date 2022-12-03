import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journalWithItems = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String items = scanner.nextLine();

        while (!items.equals("Craft!")) {

            String[] command = items.split(" - ");

            switch (command[0]) {
                case "Collect":
                    boolean isContain = isContain(journalWithItems, command[1]);
                    if (!isContain) {
                        journalWithItems.add(command[1]);
                    }
                    break;
                case "Drop":
                    boolean isContain0 = isContain(journalWithItems, command[1]);
                    if (isContain0) {
                        journalWithItems.remove(command[1]);
                    }
                    break;
                case "Combine Items":
                    String[] currentItems = command[1].split(":");
                    String item = currentItems[0];
                    String newItem = currentItems[1];
                    boolean isContain1 = isContain(journalWithItems, item);
                    if (isContain1) {
                        int index = journalWithItems.indexOf(item);
                        journalWithItems.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    boolean isContain2 = isContain(journalWithItems, command[1]);
                    if (isContain2) {
                        journalWithItems.remove(command[1]);
                        journalWithItems.add(command[1]);
                    }
                    break;
            }
            items = scanner.nextLine();
        }

        printResult(journalWithItems);
    }

    private static void printResult(List<String> journalWithItems) {
        for (int i = 0; i < journalWithItems.size(); i++) {
            if (i < journalWithItems.size() - 1) {
                System.out.print(journalWithItems.get(i) + ", ");
            } else {
                System.out.println(journalWithItems.get(i));
            }
        }
    }

    private static boolean isContain(List<String> journalWithItems, String command) {
        return journalWithItems.contains(command);
    }
}
