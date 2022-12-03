import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String inputDemons = scanner.nextLine();
        List<String> input = Arrays.stream(scanner.nextLine().split(" *,{1} *")).collect(Collectors.toList());
        Map<String, List<Double>> demonsInfo = new LinkedHashMap<>();

        for (String currentDemon : input) {
            List<Double> demonInfo = new ArrayList<>();
            //health points = all chars ascii codes sum
            //The sum of the ascii codes of all characters (excluding numbers (0-9),
            // arithmetic symbols ('+', '-', '*', '/') and delimiter dot ('.')) gives a demon's total health.
            String hpRegex = "[^+\\-*/.\\d]+";
            Pattern hpPattern = Pattern.compile(hpRegex);
            Matcher hpMatcher = hpPattern.matcher(currentDemon);
            StringBuilder demonName = new StringBuilder();
            while (hpMatcher.find()) {
                demonName.append(hpMatcher.group());
            }
            double demonHealth = 0;
            for (int j = 0; j < demonName.length(); j++) {
                char currentChar = demonName.charAt(j);
                demonHealth += currentChar;
            }
            demonInfo.add(demonHealth);

            //The sum of all numbers in his name forms his base damage.
            //Note that you should consider the plus '+' and minus '-' signs (e.g., +10 is 10 and -10 is -10).
            //However, there are some symbols ('*' and '/') that can further alter the base damage by multiplying or dividing it by
            String dmgRegex = "(|-)\\d+\\.\\d+|(|-)\\d+";
            Pattern dmgPattern = Pattern.compile(dmgRegex);
            Matcher dmgMatcher = dmgPattern.matcher(currentDemon);
            List<String> damageList = new ArrayList<>();
            while (dmgMatcher.find()) {
                damageList.add(dmgMatcher.group());
            }
            double demonDmg = 0;
            for (int k = 0; k < damageList.size(); k++) {
                double currentNumber = Double.parseDouble(damageList.get(k));
                demonDmg += currentNumber;
            }

            //However, there are some symbols ('*' and '/') that can further alter the base damage by multiplying or dividing it by 2
            // (e.g. in the name "m15*/c-5.0", the base damage is 15 + (-5.0) = 10 and then you need to multiply it by 2 (e.g. 10 * 2 = 20)
            // and then divide it by 2 (e.g. 20 / 2 = 10)).
            String multiplyingOrDividingRegex = "[\\*\\/]";
            Pattern multiplyingOrDividingPattern = Pattern.compile(multiplyingOrDividingRegex);
            Matcher multiplyingOrDividingMatcher = multiplyingOrDividingPattern.matcher(currentDemon);
            StringBuilder multiplyingOrDividing = new StringBuilder();
            while ((multiplyingOrDividingMatcher.find())) {
                multiplyingOrDividing.append(multiplyingOrDividingMatcher.group());
            }

            for (int b = 0; b < multiplyingOrDividing.length(); b++) {
                char currentSymbol = multiplyingOrDividing.charAt(b);
                if (currentSymbol == '*') {
                    demonDmg = demonDmg * 2;
                } else if (currentSymbol == '/') {
                    demonDmg = demonDmg / 2;
                }
            }

            demonInfo.add(demonDmg);
            demonsInfo.put(currentDemon, demonInfo);

        }

        for (Map.Entry<String, List<Double>> entry : demonsInfo.entrySet()) {
            System.out.printf("%s - %.0f health, %.2f damage%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
