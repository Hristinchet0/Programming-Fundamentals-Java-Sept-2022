import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.входни данни ->
        // "sh, too_long_username, !lleg@l ch@rs, jeffbutt"
        String input = scanner.nextLine();
        String[] usernames = input.split(", ");

        //2. проверка дали usernames са валидни
        for (String username : usernames) {
            //ако username е валиден
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }

    }
    //метод, който проверява дали моят username е валиден
    //true -> ако е валиден
    //false -> ако не е валиден
    private static boolean isValidUsername(String username) {
        //1. валидна дължина -> [3, 16]
        //boolean isValidLength = username.length() >= 3 && username.length() <= 16;
        if(username.length() < 3 || username.length() > 16) {
            //невалидна дължина
            return false;
        } // валидна дължина


        //2. валидно съдържание -> букви, цифри, - , _
        //true -> съдържанието на username е валидно
        //false -> съдържанието на username e невалидно
        //username = "test".toCharArray() - > масив от символи
        //boolean isValidContent = false;
        for (char symbol : username.toCharArray()) {
            if(!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                //невалиден символ -> невалиден username
                return false;
            }
        }
        //всички символи са валидни
        //isValidContent = true;

        //return isValidLength; //&& isValidContent;

        //валидна дължина и съдържание
        return true;
    }
}
