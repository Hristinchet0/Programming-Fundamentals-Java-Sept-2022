import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> dungeonRooms = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        int myHealth = 100;
        int sumOfBitcoins = 0;

        for (int i = 0; i < dungeonRooms.size(); i++) {
            String[] currentRoom = dungeonRooms.get(i).split(" ");

            if (currentRoom[0].equals("potion")) {
                int startHealth = myHealth;
                myHealth += Integer.parseInt(currentRoom[1]);
                if (myHealth > 100) {
                    myHealth = 100;
                }
                System.out.printf("You healed for %d hp.%n", myHealth - startHealth);
                System.out.printf("Current health: %d hp.%n", myHealth);
            } else if (currentRoom[0].equals("chest")) {
                int currentBitcoins = Integer.parseInt(currentRoom[1]);
                sumOfBitcoins += currentBitcoins;
                System.out.printf("You found %d bitcoins.%n", currentBitcoins);
            } else {
                int monsterHealth = Integer.parseInt(currentRoom[1]);
                myHealth -= monsterHealth;
                if (myHealth > 0) {
                    System.out.printf("You slayed %s.%n", currentRoom[0]);
                } else {
                    System.out.printf("You died! Killed by %s.%n", currentRoom[0]);
                    System.out.printf("Best room: %s%n", i + 1);
                    break;
                }
            }
        }
        if (myHealth > 0) {
            System.out.printf("You've made it!%n" +
                    "Bitcoins: %d%n" +
                    "Health: %d%n", sumOfBitcoins, myHealth);
        }
    }
}
