import java.util.Arrays;
import java.util.Scanner;

public class P04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Morse code to English (capital letters). Use this page to help you (without the numbers).
        //https://morsecode.world/international/morse2.html
        String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z"};

        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        String[] input = scanner.nextLine().split(" ");

        StringBuilder decryptedMSg = new StringBuilder();


        for (int i = 0; i < input.length; i++) {
            String currentLetter = input[i];
            if(currentLetter.equals("|")) {
                decryptedMSg.append(currentLetter);
            } else {
                for (int j = 0; j < code.length; j++) {
                    if (currentLetter.equals(code[j])) {
                        decryptedMSg.append(english[j]);
                        break;
                    }
                }
            }

        }
        System.out.println(decryptedMSg.toString().replaceAll("\\|", " "));


    }
}
