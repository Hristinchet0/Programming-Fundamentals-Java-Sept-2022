import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        String input = scanner.nextLine();
        while(!input.equals("Decode")) {
            //There are several types of instructions, split by '|'
            String[] commands = input.split("\\|");
            String command = commands[0];
            //•	"Move {number of letters}":
            //o	Moves the first n letters to the back of the string
            //commands = Move|3 -> взимаме първите 3 символа и ги местим последни
            if(command.equals("Move")) {
                int numbersOfLettersToMove = Integer.parseInt(commands[1]);
                if (numbersOfLettersToMove >= 0 && numbersOfLettersToMove <= encryptedMessage.length()) {
                    String lettersToMove = encryptedMessage.substring(0, numbersOfLettersToMove);
                    String lastLetters = encryptedMessage.substring(numbersOfLettersToMove);
                    encryptedMessage = lastLetters + lettersToMove;
                }
            } else if (command.equals("Insert")) {
                //•	"Insert {index} {value}":
                //o	Inserts the given value before the given index in the string
                // commands = Insert|2|o -> взимаме символа 'о' и го местим преди символана позиция 2
                int index = Integer.parseInt(commands[1]);
                String value = commands[2];
                if (index >= 0 && index <= encryptedMessage.length()) {
                    String firstPart = encryptedMessage.substring(0, index);
                    String secondPart = encryptedMessage.substring(index);
                    encryptedMessage = firstPart.concat(value).concat(secondPart);
                }

            } else if (command.equals("ChangeAll")) {
                //•	"ChangeAll {substring} {replacement}":
                //o	Changes all occurrences of the given substring with the replacement text
                //commands = ChangeAll|z|l -> заменяме всички символи 'z' със символа 'l'
                String substring = commands[1];
                String replacement = commands[2];
                while (encryptedMessage.contains(substring)) {
                    encryptedMessage = encryptedMessage.replace(substring, replacement);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }
}
