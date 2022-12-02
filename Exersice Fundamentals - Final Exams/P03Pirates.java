import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String targetCities = scanner.nextLine();
        Map<String, Integer> cityPopulation = new LinkedHashMap<>();
        Map<String, Integer> cityGold = new LinkedHashMap<>();

        while (!targetCities.equals("Sail")) {
            //city||population||gold
            //Tortuga||345000||1250
            String city = targetCities.split("\\|\\|")[0];
            int population = Integer.parseInt(targetCities.split("\\|\\|")[1]);
            int gold = Integer.parseInt(targetCities.split("\\|\\|")[2]);
            if (!cityPopulation.containsKey(city) && !cityGold.containsKey(city)) {
                cityPopulation.put(city, population);
                cityGold.put(city, gold);
            } else {
                int currentPopulation = cityPopulation.get(city);
                int currentGold = cityGold.get(city);
                cityPopulation.put(city, currentPopulation + population);
                cityGold.put(city, currentGold + gold);
            }

            targetCities = scanner.nextLine();
        }
        String representingEvents = scanner.nextLine();
        while (!representingEvents.equals("End")) {
            if (representingEvents.contains("Plunder")) {
                //•	"Plunder=>{town}=>{people}=>{gold}"
                String city = representingEvents.split("=>")[1];
                int killedPeople = Integer.parseInt(representingEvents.split("=>")[2]);
                int plunderedGold = Integer.parseInt(representingEvents.split("=>")[3]);

                int currentPopulation = cityPopulation.get(city) - killedPeople;
                int currentGold = cityGold.get(city) - plunderedGold;

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, plunderedGold, killedPeople);
                cityPopulation.put(city, currentPopulation);
                cityGold.put(city, currentGold);

                if (currentPopulation <= 0 || currentGold <= 0) {
                    System.out.printf("%s has been wiped off the map!%n", city);
                    cityPopulation.remove(city);
                    cityGold.remove(city);
                }

            } else if (representingEvents.contains("Prosper")) {
                //•	"Prosper=>{town}=>{gold}"
                String city = representingEvents.split("=>")[1];
                int givenGold = Integer.parseInt(representingEvents.split("=>")[2]);

                if (givenGold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int currentGold = cityGold.get(city) + givenGold;
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", givenGold, city, currentGold);
                    cityGold.put(city, currentGold);
                }
            }

            representingEvents = scanner.nextLine();
        }

        if (cityPopulation.size() > 0 && cityGold.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityPopulation.size());
            cityPopulation.entrySet()
                    .forEach(entry -> {
                        String city = entry.getKey();
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city, entry.getValue(), cityGold.get(city));
                    });


        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
