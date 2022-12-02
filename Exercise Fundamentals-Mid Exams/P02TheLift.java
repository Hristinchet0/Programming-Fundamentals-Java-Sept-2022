import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeopleForTheLift = Integer.parseInt(scanner.nextLine());
        int[] wagon = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int maxCapacity = 4; // запазваме в променлива колко е максималния капацитет на хората във вагон

        boolean noMorePeople = false;

        for (int i = 0; i < wagon.length; i++) {

            int currentWagon = wagon[i]; // текущия вагон е равен на рекущия елемент от индекса

            if(waitingPeopleForTheLift - (maxCapacity - currentWagon) == 0) { // ако чакащите хора - максималния капацитет
                // минус текущия вагон са равни на 0
                waitingPeopleForTheLift -= maxCapacity - currentWagon; // от чакащите хора изваждаме макс капацитета и
                // хората от текущия вагон
                wagon[i] = 4; // текущия вагон се запълва
                noMorePeople = true; // няма повече хора
                break;// прекъсваме итерацията и не продължаваме надолу
            } else if (waitingPeopleForTheLift - (maxCapacity - currentWagon) < 0) {
                wagon[i] += waitingPeopleForTheLift;
                waitingPeopleForTheLift = 0;
                noMorePeople = true;
                break;
            } else {
                waitingPeopleForTheLift -= maxCapacity - currentWagon;
                wagon[i] = 4;
            }
        }
        boolean emptyCabins = false;

        for (int j : wagon) {
            if (j < 4) {
                emptyCabins = true;
                break;
            }
        }
        if (noMorePeople && emptyCabins) {
            System.out.println("The lift has empty spots!");
        } else if (waitingPeopleForTheLift > 0 && !emptyCabins) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", waitingPeopleForTheLift);
        }
        for (int j : wagon) {
            System.out.print(j + " ");
        }
    }
}
