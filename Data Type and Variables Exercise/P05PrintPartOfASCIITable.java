import java.util.Scanner;

public class P05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fromASCIICode = Integer.parseInt(scanner.nextLine());
        int toASCIICode = Integer.parseInt(scanner.nextLine());

        for (int code = fromASCIICode; code <= toASCIICode; code++) {
            System.out.print((char) code + " ");
        }
    }
}
