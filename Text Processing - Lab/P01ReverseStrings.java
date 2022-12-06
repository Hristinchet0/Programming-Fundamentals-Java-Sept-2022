import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while(!input.equals("end")) {
            //String reversedWord = "";
            StringBuilder reversedSb = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                  char currentSymbol = input.charAt(i);
                  //reversedWord = reversedWord + currentSymbol;
                reversedSb.append(currentSymbol);
            }

            System.out.printf("%s = %s%n", input, reversedSb);

            input = scanner.nextLine();
        }

    }
}
