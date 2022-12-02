import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namesParticipants = scanner.nextLine(); //George, Peter, Bill, Tom
        List<String> names = Arrays.stream(namesParticipants.split(", ")).collect(Collectors.toList());

        //състезател -> дистанция
        Map<String, Integer> racerDistance = new LinkedHashMap<>();
        //вземи ми всяко едно въведено име в списъка, записвам го във мапа, като срещу него 0
        // (изминатита дистанция преди да започне състезанието),
        names.forEach(name -> racerDistance.put(name, 0));

        //regex
        String regexLetter = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetter); // шаблона за буквите
        String regexNumbers = "[0-9]"; //\d
        Pattern patternNumbers = Pattern.compile(regexNumbers); //Шаблон за всички цифри

        String input = scanner.nextLine();
        while(!input.equals("end of race")) {
            //input = G4e@55or%6g6!68e!!@
            //1. името на състезателя -> да вземем всички букти
            StringBuilder racerName = new StringBuilder();
            Matcher matcherLetters = patternLetter.matcher(input);
            //matcher = всчики текстове които отговарят на шаблона -> G, e, or, g, e
            while (matcherLetters.find()) { // конструираме името и го запазваме в StringBuilder-a
                racerName.append(matcherLetters.group());
            }

            //2. дистанцията -> сумата от всички цифриStringBuilder racerName = new StringBuilder();
            int distance = 0;
            Matcher matcherNumbers = patternNumbers.matcher(input);
            //matcher = всички текстове които отговарят на шаблона -> 4, 5, 5, 6, 6, 6, 8
            while (matcherNumbers.find()) { //докато в matcher има текст (числата) преобразувай ги в Int и ги добавяй + в distance
                distance += Integer.parseInt(matcherNumbers.group());
            }

            if(names.contains(racerName.toString())) {
                //имаме играча в първоначалния списък
                int currentDistance = racerDistance.get(racerName.toString()); // текущата дистанция избягана от играча
                racerDistance.put(racerName.toString(), currentDistance + distance); // текущата дистанция + новата дистанция

            }

            input = scanner.nextLine();
        }

        //мап racerDistances Име -> дистанция
        //без сортировка
        /* int count = 1; //реда на текущия играч
        for(Map.Entry<String, Integer> pair : racerDistance.entrySet()) {
            //pair : име -> дистанция
            if(count == 1) {
                //първи играч
                System.out.println("1st place: " + pair.getKey());
                count ++;
            } else if (count == 2) {
                //втори играч
                System.out.println("2nd place: " + pair.getKey());
                count++;
            } else if (count == 3) {
                //трети играч
                System.out.println("3rd place: " + pair.getKey());
                break;
            }
        } */

        //сортираме по дистанция във descending order низходящ ред
        //comparingByValue -> ascending order
        List<String> top3Names = racerDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //сортирали сме по Value (дистанцията) по намалшващ ред
                .limit(3)// оставяме първите 3 записа
                .map(entry -> entry.getKey()) //на всеки от трите записа взимаме ключа (името)
                .collect(Collectors.toList()); //направи ми ги на лист

        System.out.println("1st place: " + top3Names.get(0));
        System.out.println("2nd place: " + top3Names.get(1));
        System.out.println("3rd place: " + top3Names.get(2));
    }
}
