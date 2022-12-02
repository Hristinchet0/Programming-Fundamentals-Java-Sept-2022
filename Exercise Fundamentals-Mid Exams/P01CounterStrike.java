import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int winCounter = 0;


        while (true) {
            String command = scanner.nextLine();

            if (command.equals("End of battle")) {
                System.out.printf("Won battles: %d. Energy left: %d", winCounter, energy);
                break;
            }
            int distance = Integer.parseInt(command);

            if (energy - distance >= 0) {
                energy -= distance;
                winCounter++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", winCounter, energy);
                break;
            }

            if (winCounter % 3 == 0) {
                energy += winCounter;
            }
        }
    }
}
