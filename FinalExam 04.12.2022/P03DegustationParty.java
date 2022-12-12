import java.util.*;

public class P03DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> guests = new LinkedHashMap<>();

        String input = scanner.nextLine();
        int unlikedMealsCount = 0;

        while (!input.equals("Stop")) {
            String[] command = input.split("-");
            String likeOrDislike = command[0];
            String guestName = command[1];
            String meal = command[2];

            if (likeOrDislike.equals("Like")) {
                if(!guests.containsKey(guestName)) {
                    guests.put(guestName, new ArrayList<>());
                    guests.get(guestName).add(meal);
                }
                if(!guests.get(guestName).contains(meal)) {
                    guests.get(guestName).add(meal);
                }
            } else if(likeOrDislike.equals("Dislike")) {
                if(!guests.containsKey(guestName)) {
                    System.out.printf("%s is not at the party.%n", guestName);
                } else if (!guests.get(guestName).contains(meal)) {
                    System.out.printf("%s doesn't have the %s in his/her collection.%n", guestName, meal);
                } else {
                    guests.get(guestName).remove(meal);
                    System.out.printf("%s doesn't like the %s.%n", guestName, meal);
                    unlikedMealsCount++;
                }

            }

            input = scanner.nextLine();
        }
        guests.entrySet()
                .forEach(entry ->
                                System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()))
                );

        System.out.printf("Unliked meals: %d%n", unlikedMealsCount);
    }
}
