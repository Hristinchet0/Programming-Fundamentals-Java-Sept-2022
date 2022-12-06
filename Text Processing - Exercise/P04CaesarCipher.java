import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine(); //Първоначалния текст -> Programming is cool!
        StringBuilder encryptedText = new StringBuilder();
        for (char symbol : text.toCharArray()) {
            //System.out.print((char)(symbol + 3));
            char encryptSymbol = (char)(symbol + 3);
            encryptedText.append(encryptSymbol);
        }
        System.out.println(encryptedText);
    }
}
