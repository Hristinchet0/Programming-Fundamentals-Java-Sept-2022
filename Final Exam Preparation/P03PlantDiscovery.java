import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantRarityMap = new HashMap<>();
        Map<String, Double> plantRating = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);
            //plantRarityMap.putIfAbsent(plant, 0); //добави plant ако не се съдържа в Мапа със тойност 0
            plantRarityMap.put(plant, rarity); // ако го има, добави plant с нова стойност на Value -> update Value
            plantRating.put(plant, 0.0);
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] tokens = input.split("[: -]+");
            String command = tokens[0];
            String plant = tokens[1];


            if (!plantRarityMap.containsKey(plant)) {
                System.out.println("error");
            } else {
                switch (command) {
                    case "Rate":
                        Double rate = Double.parseDouble(tokens[2]);
                        if (plantRating.get(plant) == 0) {
                            plantRating.put(plant, rate);
                        } else {
                            double newRate = (plantRating.get(plant) + rate) / 2;
                            plantRating.put(plant, newRate);
                        }
                        break;
                    case "Update":
                        int value = Integer.parseInt(tokens[2]);
                        plantRarityMap.put(plant, value);
                        break;
                    case "Reset":
                        plantRating.put(plant, 0.0);

                        break;
                }
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantRarityMap.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), plantRating.get(entry.getKey()));
        }
    }
}
