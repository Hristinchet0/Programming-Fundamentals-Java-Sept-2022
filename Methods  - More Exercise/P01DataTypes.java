import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String firstCommand = scanner.nextLine();
        String secondCommand = scanner.nextLine();

        dataTypes(firstCommand, secondCommand);

    }
    public static void dataTypes(String firstCommand, String secondCommand) {
        if (firstCommand.equals("int")) {
            int num = Integer.parseInt(secondCommand);
            int result = num * 2;
            System.out.println(result);
        }else if (firstCommand.equals("real")) {
            double num = Double.parseDouble(secondCommand);
            double result = num * 1.5;
            System.out.printf("%.2f%n", result);
        }else if (firstCommand.equals("string")) {
            System.out.println("$" + secondCommand + "$");
        }
    }
}
