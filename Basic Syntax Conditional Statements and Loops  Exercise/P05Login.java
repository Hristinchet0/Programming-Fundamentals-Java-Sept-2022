import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String enteredPassword = scanner.nextLine();

        int counter = 0;

        String correctPassword = new StringBuffer(userName).reverse().toString();

        while (!enteredPassword.equals(correctPassword)) {
            counter ++;
            if (counter == 4) {
                break;
            }
            System.out.println("Incorrect password. Try again.");
            enteredPassword = scanner.nextLine();
        }
        if (counter == 4) {
            System.out.printf("User %s blocked!", userName);
        } else {
            System.out.printf("User %s logged in.", userName);
        }
    }
}
