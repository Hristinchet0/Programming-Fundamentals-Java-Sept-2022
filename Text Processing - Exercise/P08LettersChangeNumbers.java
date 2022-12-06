import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // A12b s17G кодове разделени с 1 или повече интервали
        String[] codes = input.split("\\s+");

        double totalSum = 0; //сумата от модифицираните числа на всеки код
        for (String code : codes) {
            //код: {буква}{число}{буква}
            //да модифицирам числото в кода спрямо буквите
            double modifiedNumber = getModifiedNumber(code);
            //да добавя модифицираното число към сумата
            totalSum += modifiedNumber;
        }

        System.out.printf("%.2f", totalSum);


    }

    //метод който връща модифицираното число от кода
    private static double getModifiedNumber(String code) {
        //код: "{буква}{число}{буква}"
        //"A12b"
        char firstLetter = code.charAt(0); //'A'
        char secondLetter = code.charAt(code.length() - 1); //'b'
        double number = Double.parseDouble(code.replace(firstLetter, ' ') //' 12b'
                .replace(secondLetter, ' ') //' 12 '
                .trim()); // '12' -> Double.parseDouble -> 12.0

        //1. проверка за firstLetter -> главна или малка
        if (Character.isUpperCase(firstLetter)) {
            //главна -> ascii e [65; 90]
            //•	If it's uppercase, you divide the number by the letter's position in the alphabet.
            int positionUpperLetter = (int) firstLetter - 64; //позицията на буквата в alphabetic table
            number = number / positionUpperLetter;
        } else {
            //малка -> ascii e [97; 122]
            //•	If it's lowercase, you multiply the number with the letter's position in the alphabet.
            int positionLowerLetter = (int) firstLetter - 96;
            number = number * positionLowerLetter;
        }
        //2.проверка за втората буква -> главна или малка
        if (Character.isUpperCase(secondLetter)) {
            //главна -> ascii e [65; 90]
            //•	If it's uppercase, you subtract its position from the resulted number.
            int positionUpperLetter = (int) secondLetter - 64; //позицията на буквата в alphabetic table
            number = number - positionUpperLetter;
        } else {
            //малка -> ascii e [97; 122]
            //•	If it's lowercase, you add its position to the resulted number.
            int positionLowerLetter = (int) secondLetter - 96;
            number = number + positionLowerLetter;
        }

        //връщам модифицираното число
        return number;

    }
}
