import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Peter-Java-84
        String input = scanner.nextLine();
        Map<String, Integer> userPoints = new LinkedHashMap<>();
        Map<String, Integer> languageCounter = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] command = input.split("-");
            String username = command[0];
            if (command.length == 3) {
                String language = command[1];
                int points = Integer.parseInt(command[2]);
                if(!userPoints.containsKey(username)) {
                    userPoints.put(username, points);
                } else {
                    if(points > userPoints.get(username)) {
                        userPoints.put(username, points);
                    }
                }
                if(!languageCounter.containsKey(language)) {
                    languageCounter.put(language, 1);
                } else {
                    languageCounter.put(language, languageCounter.get(language) + 1);
                }
            } else {
                userPoints.remove(username);
            }

            input = scanner.nextLine();
        }

//        System.out.println("Results:");
//        userPoints.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
//                .thenComparing(Map.Entry.comparingByKey()))
//                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
//
//        System.out.println("Submissions:");
//        languageCounter.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
//                .thenComparing(Map.Entry.comparingByKey()))
//                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

        System.out.println("Results:");
        userPoints.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));

        System.out.println("Submissions:");
        languageCounter.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
