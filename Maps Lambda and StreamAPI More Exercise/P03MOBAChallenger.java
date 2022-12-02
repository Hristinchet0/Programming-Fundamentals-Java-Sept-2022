import java.util.*;

public class P03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You will receive several input lines in one of the following formats:
        //"{player} -> {position} -> {skill}"
        //"{player} vs {player}"
        //You should end your program when you receive the command "Season end".

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> playerInformation = new LinkedHashMap<>();


        while (!input.equals("Season end")) {

            if (input.contains("->")) {
                String player = input.split("\\s+->\\s+")[0];
                String position = input.split("\\s+->\\s+")[1];
                int skill = Integer.parseInt(input.split("\\s+->\\s+")[2]);
                if (!playerInformation.containsKey(player)) {
                    playerInformation.put(player, new LinkedHashMap<>());
                    playerInformation.get(player).put(position, skill);
                } else {
                    if (playerInformation.get(player).containsKey(position)) {
                        if (playerInformation.get(player).get(position) < skill) {
                            playerInformation.get(player).put(position, skill);
                        }
                    } else {
                        playerInformation.get(player).put(position, skill);
                    }
                }


            }

            if (input.contains("vs")) {
                //Compare their positions,
                // 1.if they got at least one in common, the player with better total skill points wins,
                // and the other is demoted from the tier -> remove him.
                // 2.If they have the same total skill points, the duel is a tie, and they both continue in the Season.
                String player1 = input.split("\\s+vs\\s+")[0];
                String player2 = input.split("\\s+vs\\s+")[1];
                if (playerInformation.containsKey(player1) && playerInformation.containsKey(player2)) {
                    boolean isEquals = false;
                    for (String p1 : playerInformation.get(player1).keySet()) {
                        for (String p2 : playerInformation.get(player2).keySet()) {
                            if (p1.equals(p2)) {
                                isEquals = true;
                                break;
                            }
                        }
                    }
                    if (isEquals) {
                        ifEquals(playerInformation, player1, player2);
                    }
                }
            }


            input = scanner.nextLine();
        }

        List<Map.Entry<String, LinkedHashMap<String, Integer>>> toSort = new ArrayList<>(playerInformation.entrySet());
        toSort.sort((p1, p2) -> {
            int sort = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                    p1.getValue().values().stream().mapToInt(i -> i).sum());
            if (sort == 0) {
                sort = p1.getKey().compareTo(p2.getKey());
            }
            return sort;
        });
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : toSort) {
            System.out.printf("%s: %d skill\n", entry.getKey(), entry.getValue().values().stream().
                    mapToInt(i -> i).sum());
            entry.getValue().entrySet().stream().sorted((e1, e2) -> {
                int sort = Integer.compare(e2.getValue(), e1.getValue());
                if (sort == 0) {
                    sort = e1.getKey().compareTo(e2.getKey());
                }
                return sort;
            }).forEach(e -> System.out.printf("- %s <::> %d\n", e.getKey(), e.getValue()));
        }
    }

    private static void ifEquals(Map<String, LinkedHashMap<String, Integer>> playerInformation, String player1, String player2) {
        if (playerInformation.get(player1).values().stream().mapToInt(i -> i).sum() >
                playerInformation.get(player2).values().stream().mapToInt(i -> i).sum()) {
            playerInformation.remove(player2);
        } else if (playerInformation.get(player1).values().stream().mapToInt(i -> i).sum() <
                playerInformation.get(player2).values().stream().mapToInt(i -> i).sum()) {
            playerInformation.remove(player1);
        }
    }
}
