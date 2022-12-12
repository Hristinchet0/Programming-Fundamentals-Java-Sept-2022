import java.util.Scanner;

public class P01DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String decryptingCommands = scanner.nextLine();

        while (!decryptingCommands.equals("Finish")) {
            String[] commands = decryptingCommands.split("\\s+");
            String command = commands[0];
            //Replace {currentChar} {newChar}
            if (command.equals("Replace")) {
                String currentChar = commands[1];
                String newChar = commands[2];

                while (message.contains(currentChar)) {
                    message = message.replace(currentChar, newChar);
                }

                System.out.println(message);
            } else if (command.equals("Cut")) {
                //Cut {startIndex} {endIndex}
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);

                if (startIndex >= 0 && endIndex < message.length()) {
                    String first = message.substring(0, startIndex);
                    String second = message.substring(endIndex + 1);
                    message = first + second;
                    System.out.println(message);
                } else {
                    System.out.println("Invalid indices!");
                }

            } else if (command.equals("Make")) {
                //Make {Upper/Lower}
                String upperOrLower = commands[1];
                if (upperOrLower.equals("Upper")) {
                    message = message.toUpperCase();
                } else if (upperOrLower.equals("Lower")) {
                    message = message.toLowerCase();
                }
                System.out.println(message);
            } else if (command.equals("Check")) {
                //Check {string}
                String substring = commands[1];
                if (message.contains(substring)) {
                    System.out.println("Message contains " + substring);
                } else {
                    System.out.println("Message doesn't contain " + substring);
                }
            } else if (command.equals("Sum")) {
                //Sum {startIndex} {endIndex}
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                if (startIndex >= 0 && endIndex < message.length()) {
                    int sum = 0;

                    for (int i = startIndex; i <= endIndex; i++) {
                        sum += message.charAt(i);
                    }
                    System.out.println(sum);
                } else {
                    System.out.println("Invalid indices!");
                }
            }


            decryptingCommands = scanner.nextLine();
        }
    }
}
