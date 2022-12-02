import java.awt.image.AbstractMultiResolutionImage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> parkingUsers = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            String userName = data[1];
            if(command.equals("register")) {
                String licensePlateNumber = data[2];

                if (!parkingUsers.containsKey(userName)) {
                    parkingUsers.put(userName, licensePlateNumber);
                    System.out.println(userName + " registered " + licensePlateNumber + " successfully");
                }  else {
                    System.out.println("ERROR: already registered with plate number " + licensePlateNumber);
                }
            }

            if (command.equals("unregister")) {
                if (!parkingUsers.containsKey(userName)) {
                    System.out.println("ERROR: user " + userName + " not found");
                } else {
                    parkingUsers.remove(userName);
                    System.out.println(userName + " unregistered successfully");
                }
            }
        }

        parkingUsers.forEach((userName, licensePlateNumber) -> System.out.println(userName + " => " + licensePlateNumber));
    }
}
