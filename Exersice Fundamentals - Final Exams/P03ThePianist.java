import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> pieceComposer = new LinkedHashMap<>();
        Map<String, String> pieceKey = new LinkedHashMap<>();
        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPieces; i++) {
            String piecesInfo = scanner.nextLine();
            String piece = piecesInfo.split("\\|")[0];
            String composer = piecesInfo.split("\\|")[1];
            String key = piecesInfo.split("\\|")[2];
            pieceComposer.put(piece, composer);
            pieceKey.put(piece, key);

        }
        String commands = scanner.nextLine();

        while (!commands.equals("Stop")) {
            if (commands.contains("Add")) {
                String piece = commands.split("\\|")[1];
                String composer = commands.split("\\|")[2];
                String key = commands.split("\\|")[3];
                if(pieceComposer.containsKey(piece) && pieceKey.containsKey(piece)) {
                    System.out.printf("%s is already in the collection!%n", piece);
                } else {
                    pieceComposer.put(piece, composer);
                    pieceKey.put(piece, key);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                }

            } else if (commands.contains("Remove")) {
                String piece = commands.split("\\|")[1];
                if(pieceComposer.containsKey(piece) && pieceKey.containsKey(piece)) {
                    pieceComposer.remove(piece);
                    pieceKey.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            } else if (commands.contains("ChangeKey")) {
                String piece = commands.split("\\|")[1];
                String newKey = commands.split("\\|")[2];
                if (pieceComposer.containsKey(piece) && pieceKey.containsKey(piece)) {
                    pieceKey.put(piece, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            }

            commands = scanner.nextLine();
        }

        //Upon receiving the "Stop" command, you need to print all pieces in your collection in the following format:
        //"{Piece} -> Composer: {composer}, Key: {key}"
        pieceComposer.entrySet()
                .forEach(entry -> {
                    String piece = entry.getKey();
                    System.out.printf("%s -> Composer: %s, Key: %s%n", piece, entry.getValue(), pieceKey.get(piece));
                });
    }
}
