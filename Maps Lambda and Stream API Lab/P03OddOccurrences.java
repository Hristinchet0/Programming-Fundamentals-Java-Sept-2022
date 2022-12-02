
import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();
        for (String word : inputArr) {
            word = word.toLowerCase();

            wordsMap.putIfAbsent(word, 0); //добави ми ако не се съдържа ключа
            wordsMap.put(word, wordsMap.get(word) + 1); //добави ми на този ключ новата стойност

//            if(!wordsMap.containsKey(word)) {
//                wordsMap.put(word, 0);
//            }
//            wordsMap.put(word, wordsMap.get(word) + 1);
        }
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                resultList.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", resultList));

    }
}
