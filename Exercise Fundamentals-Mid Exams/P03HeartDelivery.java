import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighborhoodHearts = Arrays.stream(scanner.nextLine().split("@+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        int cupidPosition = 0;

        while (!input.equals("Love!")) {

            String[] command = input.split("\\s+");
            int jumpLength = Integer.parseInt(command[1]);
            cupidPosition += jumpLength;

            if (cupidPosition >= neighborhoodHearts.size()) {
                cupidPosition = 0;
            }

            if (neighborhoodHearts.get(cupidPosition) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", cupidPosition);
                input = scanner.nextLine();
                continue;
            }
            neighborhoodHearts.set(cupidPosition, neighborhoodHearts.get(cupidPosition) - 2);

            if (neighborhoodHearts.get(cupidPosition) == 0) {
                System.out.printf("Place %d has Valentine's day.%n", cupidPosition);
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", cupidPosition);

        int countCupid = 0;
        for (int i = 0; i < neighborhoodHearts.size(); i++) {
            int number;
            number = neighborhoodHearts.get(i);
            int currentAdress = number;
            if(currentAdress != 0) {
                countCupid++;
            }
        }

        if (countCupid != 0) {
            System.out.printf("Cupid has failed %d places.", countCupid);
        } else {
            System.out.println("Mission was successful.");

        }

    }
}
