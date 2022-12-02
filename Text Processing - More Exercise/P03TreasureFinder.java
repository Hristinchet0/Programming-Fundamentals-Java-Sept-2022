import java.util.*;
import java.util.stream.Collectors;

public class P03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On the first line, you will receive a key (sequence of numbers).
        List<Integer> key = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        //On the next few lines, until you receive "find", you will get lines of strings.
        String msg = scanner.nextLine();

        StringBuilder decryptedMSg = new StringBuilder(); // декриптираното съобщение

        int firstIndexOfTreasure; // първи индекс на съкровището
        int lastIndexOfTreasure; // последен индекс на съкровището
        int firstIndexOfCoordinates; // първи индекс на координатите
        int lastIndexOfCoordinates; // последен индекс на координатите

        String treasure; // тук ще извадим съкровището
        String coordinates; // тук ще извадим координатите

        while (!msg.equals("find")) {
            int counter = 0; // колко пъти минаваме през съобщението
            //You have to loop through every string and !!!decrease!!! the ASCII code of each character with a corresponding number of the key sequence.
            for (int i = 0; i < msg.length(); i++) {
                int letter = msg.charAt(i) - key.get(counter);
                counter++;
                //If the length of the key sequence is less than the string sequence, you start looping from the beginning of the key.
                if (counter >= key.size()) {
                    counter = 0;
                }
                decryptedMSg.append((char) letter); //добавяме буквата
            }
            //you will get a type of treasure and its coordinates.
            // The type will be between the symbol "&" and the coordinates will be between the symbols "<" and ">".
            firstIndexOfTreasure = decryptedMSg.toString().indexOf('&');
            lastIndexOfTreasure = decryptedMSg.toString().lastIndexOf('&');
            firstIndexOfCoordinates = decryptedMSg.toString().indexOf('<');
            lastIndexOfCoordinates = decryptedMSg.toString().lastIndexOf('>');

            treasure = decryptedMSg.substring(firstIndexOfTreasure + 1, lastIndexOfTreasure);
            coordinates = decryptedMSg.substring(firstIndexOfCoordinates + 1, lastIndexOfCoordinates);

            decryptedMSg = new StringBuilder();

            System.out.printf("Found %s at %s%n", treasure, coordinates);

            msg = scanner.nextLine();

        }
    }
}
