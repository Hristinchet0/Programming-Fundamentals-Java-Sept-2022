import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //String text = scanner.nextLine().replaceAll(" ", ""); - заменя всички интервали с 'нищо'.
        //символ -> бр. срещания
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();
        //HashMap - няма значение редът на записите
        //LinkedHashMap - подреждат се спрямо реда на добавяне
        //TreeMap - записите се сортират спрямо техния ключ -> възходящ ред


        for (char symbol : text.toCharArray()) {

            if(symbol == ' ') {
                continue; //порпуска всичко надолу и преминава към следващия символ
            }
            //"Text" -> ['T', 'e', 'x', 't']
            if(!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
            } else {
                //int currentCount = symbolsCount.get(symbol);
                symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
            }
        }

        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
