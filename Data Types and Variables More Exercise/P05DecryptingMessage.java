import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decriptionKey = Integer.parseInt(scanner.nextLine());
        int charCount = Integer.parseInt(scanner.nextLine());

        String msg = "";

        for (int i = 1; i <= charCount ; i++) {
            char letter = scanner.nextLine().charAt(0);
            msg += (char) ((int)letter + decriptionKey);
        }

        System.out.println(msg);
    }
}
