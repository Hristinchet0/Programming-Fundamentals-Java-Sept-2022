import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> information = new LinkedHashMap<>();

        while (!input.equals("no more time")) {
            //"{username} -> {contest} -> {points}"
            String username = input.split("\\s+->\\s+")[0];
            String contest = input.split("\\s+->\\s+")[1];
            int points = Integer.parseInt(input.split("\\s+->\\s+")[2]);
            //. You should check if such a contest already exists, and if not, add it, otherwise,
            // check if the current user is participating in the contest. If he is participating,
            // take the higher score, otherwise, just add it.
            if (!information.containsKey(contest)) {
                information.put(contest, new LinkedHashMap<>());
                information.get(contest).put(username, points);
            } else {
                if (information.get(contest).containsKey(username)) {
                    if (information.get(contest).get(username) < points) {
                        information.get(contest).put(username, points);
                    }
                } else {
                    information.get(contest).put(username, points);
                }
            }


            input = scanner.nextLine();
        }

        AtomicInteger counter = new AtomicInteger();
        information.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            counter.set(1);
            HashMap<String, Integer> studentsRow;
            studentsRow = value;
            studentsRow.entrySet().stream().sorted((a1, a2) -> {
                if(Objects.equals(a2.getValue(), a1.getValue())) {
                    return a1.getKey().compareTo(a2.getKey());
                } else {
                    return a2.getValue() - a1.getValue();
                }
            }).forEach((s) -> System.out.printf("%d. %s <::> %d%n", counter.getAndIncrement(), s.getKey(), s.getValue()));
        });

        Map<String, Integer> individualPoints = new TreeMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : information.entrySet()) {
            for (Map.Entry<String, Integer> go : entry.getValue().entrySet()) {
                individualPoints.putIfAbsent(go.getKey(), 0);
                individualPoints.put(go.getKey(), individualPoints.get(go.getKey()) + go.getValue());
            }
        }

        System.out.println("Individual standings:");

        counter.set(1);

        List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
        for (Map.Entry<String, Integer> element : individualPoints.entrySet()) {
            toSort.add(element);
        }
        toSort.sort((a2, a1) -> {
            int sort = Integer.compare(a1.getValue(), a2.getValue());
            if (sort == 0) {
                sort = a2.getKey().compareTo(a1.getKey());
            }
            return sort;

        });
        for (Map.Entry<String, Integer> element : toSort) {
            System.out.printf("%d. %s -> %d%n", counter.getAndIncrement(), element.getKey(), element.getValue());
        }
    }
}