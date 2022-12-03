import java.util.Scanner;

public class P01TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int dayOfAdventure = Integer.parseInt(scanner.nextLine());
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        double energyOfGroup = Double.parseDouble(scanner.nextLine());
        double waterForOnePerson = Double.parseDouble(scanner.nextLine());
        double foodForOnePerson = Double.parseDouble(scanner.nextLine());

        double totalWater = dayOfAdventure * numberOfPlayers * waterForOnePerson;
        double totalFood = dayOfAdventure * numberOfPlayers * foodForOnePerson;

        int waterDay = 0;
        int foodDay = 0;

        for (int i = 0; i < dayOfAdventure; i++) {
            double energyLost = Double.parseDouble(scanner.nextLine());

            energyOfGroup -= energyLost;

            waterDay += 1;
            foodDay += 1;

            if (energyOfGroup <= 0.0) {
                break;
            }
            if (waterDay >= 2) {
                totalWater -= totalWater * 0.3;
                energyOfGroup += energyOfGroup * 0.05;
                waterDay = 0;
            }
            if (foodDay >= 3) {
                totalFood -= totalFood / numberOfPlayers;
                energyOfGroup += energyOfGroup * 0.1;
                foodDay = 0;
            }
        }
        if (energyOfGroup >= 1) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energyOfGroup);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }

    }
}
