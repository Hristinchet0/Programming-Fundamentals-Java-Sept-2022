import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            //"swap {index1} {index2}" takes two elements and swap their places.
            //"multiply {index1} {index2}" takes the element at the 1st index and multiplies it with the element at 2nd index. Save the product at the 1st index.
            //"decrease" decreases all elements in the array with 1.
            if (command.contains("swap")) {
                //"swap {index1} {index2}" -> "swap 2 3".split(" ") -> ["swap", "2", "3"]
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                //1.взимаме елемент от първия индекс
                int element1 = numbers[index1];
                //2.взимае елемент от втория индекс
                int element2 = numbers[index2];
                //3.размяна
                numbers[index1] = element2;
                numbers[index2] = element1;

            } else if (command.contains("multiply")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                //1.взимаме елемент от първия индекс
                int element1 = numbers[index1];
                //2.взимае елемент от втория индекс
                int element2 = numbers[index2];
                //умножаваме ги
                int product = element1 * element2;
                numbers[index1] = product;

            } else if (command.equals("decrease")) {
                //обхождаме всички елементи и ги намаляваме с 1 (-1)
                for (int index = 0; index <= numbers.length - 1; index++) {
                    numbers[index]--;
                    // numbers[index] -= 1;
                    // numbers[index] = numbers[index] - 1;

                }
            }
            command = scanner.nextLine();
        }
        // отпечатваме масива разделен със запетая и интервал,
        // но без да слагаме ", " след последното число!!!
        for (int index = 0; index <= numbers.length - 1 ; index++) {
            int currentNumber = numbers[index];
            //когато не сме на последното число
            if (index != numbers.length - 1) {
                System.out.print(currentNumber + ", ");
            }else { // когато сме на последното число
                System.out.print(currentNumber);
            }
        }

    }
}
