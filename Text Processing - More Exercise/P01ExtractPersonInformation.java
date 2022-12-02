import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n lines of strings
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            //and extracts the name and age of a given person
            String input = scanner.nextLine();
            //inout: Here is a name @George| and an age #18*
            //The person's name will be between "@" and "|".
            int startIndexOfName = input.indexOf('@');
            int endIndexOfName = input.indexOf('|');
            String name = input.substring(startIndexOfName + 1, endIndexOfName);
            //The person's age will be between "#" and "*".
            int startIndexOfAge = input.indexOf('#');
            int endIndexOfAge = input.indexOf('*');
            String age = input.substring(startIndexOfAge + 1, endIndexOfAge);
            //For each found name and age, print a line in the following format "{name} is {age} years old."
            System.out.printf("%s is %s years old.%n", name, age);

        }
    }
}
