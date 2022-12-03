import java.util.*;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {

            String[] commands = command.split("\\s+");

            switch (commands[0]) {
                case "Urgent":
                    if (!shoppingList.contains(commands[1])) {
                        shoppingList.add(0, commands[1]);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList.contains(commands[1])) {
                        shoppingList.remove(commands[1]);
                    }
                    break;

                case "Correct":
                    if (shoppingList.contains(commands[1])) {
                        int index = shoppingList.indexOf(commands[1]);
                        shoppingList.add(index, commands[2]);
                        shoppingList.remove(commands[1]);
                    }

                    break;

                case "Rearrange":
                    if (shoppingList.contains(commands[1])) {
                        shoppingList.remove(commands[1]);
                        shoppingList.add(commands[1]);
                    }

                    break;
            }

            command = scanner.nextLine();
        }
        printNewShoppingList(shoppingList);

    }

    private static void printNewShoppingList(List<String> shoppingList) {
        for (int i = 0; i < shoppingList.size(); i++) {
            if (i < shoppingList.size() - 1) {
                System.out.print(shoppingList.get(i) + ", ");
            } else {
                System.out.println(shoppingList.get(i));
            }
        }
    }
}

