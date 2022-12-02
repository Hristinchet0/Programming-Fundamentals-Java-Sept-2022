import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Strings in format "{contest}:{password for contest}" until the "end of contests" command.
        // There will be no case with two equal contests.
        String input = scanner.nextLine();
        LinkedHashMap<String, String> passwordsContests = new LinkedHashMap<>();
        while (!input.equals("end of contests")) {
            //Part One Interview:success
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            if (!passwordsContests.containsKey(contest)) {
                passwordsContests.put(contest, password);
            }
            input = scanner.nextLine();
        }

        //you will receive another type of input in the format "{contest}=>{password}=>{username}=>{points}"
        // until you receive "end of submissions".

        input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> usernamePoints = new TreeMap<>();

        while (!input.equals("end of submissions")) {
            //"{contest}=>{password}=>{username}=>{points}"
            //C# Fundamentals=>fundPass=>Tanya=>350
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            if (passwordsContests.containsKey(contest)) {
                if (passwordsContests.get(contest).equals(password)) {
                    LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                    course.put(contest, points);

                    if (!usernamePoints.containsKey(username)) {
                        usernamePoints.put(username, course);
                    } else {
                        if (!usernamePoints.get(username).containsKey(contest)) {
                            usernamePoints.get(username).put(contest, points);
                        } else {
                            usernamePoints.get(username).put(contest, Math.max(points, usernamePoints.get(username).get(contest)));

                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        int totalPoints = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : usernamePoints.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalPoints) {
                totalPoints = sum;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : usernamePoints.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalPoints) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalPoints);
            }
        }

        System.out.println("Ranking:");
        usernamePoints.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue())
                    .forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });

    }
}
