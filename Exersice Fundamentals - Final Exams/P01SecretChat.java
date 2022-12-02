import java.util.Scanner;
import java.util.regex.Pattern;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String concealedMessage = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            if(input.contains("InsertSpace")) {
                int index = Integer.parseInt(input.split(":\\|:")[1]);
                String firstPart = concealedMessage.substring(0, index);
                String secondPart = concealedMessage.substring(index);
                concealedMessage = firstPart + " " + secondPart;
                System.out.println(concealedMessage);

            } else if (input.contains("Reverse")) {
                String substring = input.split(":\\|:")[1];
                if (concealedMessage.contains(substring)) {
                    //concealedMessage = concealedMessage.replaceFirst(substring,"").concat(new StringBuilder(substring).reverse().toString()); -> Zero test #2 (Runtime error) 100/ 100
                    concealedMessage = concealedMessage.replaceFirst(Pattern.quote(substring),"").concat(new StringBuilder(substring).reverse().toString()); // 100/100
                    System.out.println(concealedMessage);
                } else {
                    System.out.println("error");
                }

            }else if (input.contains("ChangeAll")) {
                String substring = input.split(":\\|:")[1];
                String replacement = input.split(":\\|:")[2];
                while (concealedMessage.contains(substring)) {
                    concealedMessage = concealedMessage.replace(substring, replacement);
                }
                System.out.println(concealedMessage);

            }

            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", concealedMessage);
    }
}
