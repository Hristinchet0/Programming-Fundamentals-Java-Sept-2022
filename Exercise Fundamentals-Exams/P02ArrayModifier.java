import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        //•	"swap {index1} {index2}" takes two elements and swap their places.
        //•	"multiply {index1} {index2}" takes element at the 1st index and multiply it with the element at 2nd index. Save the product at the 1st index.
        //•	"decrease" decreases all elements in the array with 1.

        while(!command.equals("end")) {

            if (command.contains("swap")) { // ако командата СЪДЪРЖА (contains) "swap"
                //взимаме искания индекс и го запазваме в променлива.
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                //взимаме елемент от първия индекс и го запазваме
                int element1 = numbers[index1];
                //взимаме елемент от втория индекс и го запазваме
                int element2 = numbers[index2];
                //размяна
                numbers[index1] = element2;
                numbers[index2] = element1;
            } else if (command.contains("multiply")) {
                //взимаме искания индекс и го запазваме в променлива.
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                //взимаме елемент от първия индекс и го запазваме
                int element1 = numbers[index1];
                //взимаме елемент от втория индекс и го запазваме
                int element2 = numbers[index2];
                //нова променлива за резултата от умножението
                int result = element1 * element2;
                //запазваме резултата в първия индекс
                numbers[index1] = result;
            } else if (command.contains("decrease")) {
                //За да намалим всички елементи с 1ца -> обхождаме всички елементи и ги намаляваме с 1 (-1)
                for (int i = 0; i <= numbers.length - 1; i++) {
                    numbers[i]--;
                }
            }

            command = scanner.nextLine();
        }
        // отпечатваме масива разделен със запетая и интервал,но без да слагаме ", " след последното число!!!
        for (int i = 0; i <= numbers.length - 1 ; i++) {
            int currentNumber = numbers[i];
            //ако не сме на последното число
            if (i != numbers.length - 1) {
                System.out.print(currentNumber + ", ");
            }else { // когато сме на последното число
                System.out.print(currentNumber);
            }
        }
    }
}
