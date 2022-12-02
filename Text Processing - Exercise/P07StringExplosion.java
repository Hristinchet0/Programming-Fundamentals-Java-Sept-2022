import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //abv>1>1>2>2asdasd

        StringBuilder textBuilder = new StringBuilder(input);
        int totalStrength = 0; //общата сила
        for (int position = 0; position <= textBuilder.length() - 1; position++) {
            char currentSymbol = textBuilder.charAt(position);
            if (currentSymbol == '>') {
                //експлозия
                //char '1' -> "1" -> int 1
                int explosionStrength = Integer.parseInt(textBuilder.charAt(position + 1) + "");
                totalStrength += explosionStrength;
            } else if (currentSymbol != '>' && totalStrength > 0) {
                //премахвам
                textBuilder.deleteCharAt(position);
                totalStrength--;
                //връщаме 1 позиция назад, защото задари премахнатия символ ще пропуснем следващия
                position--;
            }
        }
        System.out.println(textBuilder);

    }
}
