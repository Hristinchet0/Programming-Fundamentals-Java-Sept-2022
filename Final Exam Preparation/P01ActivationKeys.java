import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] commands = input.split(">>>");
            String command = commands[0];
            int startIndex = 0;
            int endIndex = 0;
            String substring = "";
            switch (command) {
                //•	"Contains>>>{substring}":
                //o	If the raw activation key contains the given substring, prints: "{raw activation key} contains {substring}".
                //o	Otherwise, prints: "Substring not found!"
                case "Contains":
                    substring = commands[1];

                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }

                    break;
                case "Flip":
                    //•	"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}":
                    //o	Changes the substring between the given indices (the end index is exclusive) to upper or lower case and then prints the activation key.
                    //o	All given indexes will be valid.
                    String upperOrLower = commands[1];
                    startIndex = Integer.parseInt(commands[2]);
                    endIndex = Integer.parseInt(commands[3]);
                    substring = activationKey.substring(startIndex, endIndex);

                    if (upperOrLower.equals("Upper")) {
                        activationKey = activationKey.replace(substring, substring.toUpperCase());

                    } else {
                        activationKey = activationKey.replace(substring, substring.toLowerCase());

                    }

                    System.out.println(activationKey);
                    break;
                case "Slice":
                    //•	"Slice>>>{startIndex}>>>{endIndex}":
                    //o	Deletes the characters between the start and end indices (the end index is exclusive) and prints the activation key.
                    //o	Both indices will be valid.
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);
                    substring = activationKey.substring(startIndex, endIndex);
                    activationKey = activationKey.replace(substring, "");
                    System.out.println(activationKey);

                    break;
            }
            input = scanner.nextLine();
        }
        //o	"•	After the "Generate" command is received, print:
        //o	"Your activation key is: {activation key}""
        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}
