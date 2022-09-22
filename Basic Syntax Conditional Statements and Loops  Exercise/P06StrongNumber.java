import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         int number = Integer.parseInt(scanner.nextLine()); //стойността на числото
         int startNumber = number; //първоначално въведената стойност на числото

         //4! = 1.2.3.4 = 24
        //145! = 1.1 + 1.2.3.4 + 1.2.3.4.5 = 1 + 24 + 120 = 145 Strong number
        //Алгоритъм за всички цифри: 2345
        //1. намираме последната цифра = числото % 10
        //2.имаме последната цифра 5 (rabotim s neq)
        //3.Махаме последната цифра: числото / 10
        //4.имаме последната цифра 4

        int sumFactoriel = 0; // сума от факториела

        while (number > 0) {
            int lastDight = number % 10; // последна цифра
            //намираме факториела на числото lastdigit
            int fact = 1;
            for (int i = 1; i <= lastDight; i++) {
                fact = fact * i;
            }
            //сумираме факториела
            sumFactoriel += fact;

            number = number / 10; // премахваме последната цифра
        }
        //проверката дали е Strong число
        if (sumFactoriel == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }


    }
}
