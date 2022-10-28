import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String lineInput = scanner.nextLine();

        while(!lineInput.equals("end")) {
            String[] commandArr = lineInput.split(" ");
            String command = commandArr[0];

            switch (command) {
                case "Add":
                    int numToAdd = Integer.parseInt(commandArr[1]);
                    numberList.add(numToAdd);
                    break;
                case "Remove":
                    int numToRemove = Integer.parseInt(commandArr[1]);
                    numberList.remove(Integer.valueOf(numToRemove));
                    break;
                case "RemoveAt":
                    int indexRemove = Integer.parseInt(commandArr[1]);
                    numberList.remove(indexRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commandArr[1]);
                    int indexToInsert = Integer.parseInt(commandArr[2]);
                    numberList.add(indexToInsert, numberToInsert);
                    break;
            }

            lineInput = scanner.nextLine();
        }
        System.out.println(numberList.toString().replaceAll("[\\[\\],]", ""));
    }
}
