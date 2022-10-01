import java.util.Scanner;

public class P01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.входни данни
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int forthNumber = Integer.parseInt(scanner.nextLine());
        //2,((първото + второто ) / третото) + четвъртото
        int result = ((firstNumber + secondNumber) / thirdNumber) * forthNumber;
        //3, печатаме
        System.out.println(result);


    }
}
