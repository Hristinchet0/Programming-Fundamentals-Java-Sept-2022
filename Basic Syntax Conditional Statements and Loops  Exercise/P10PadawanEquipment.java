import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	The amount of money George Lucas has – the floating-point number in the range [0.00…1,000.00].
        //•	The count of students – integer in the range [0…100].
        //•	The price of lightsabers for a single saber – the floating-point number in the range [0.00…100.00].
        //•	The price of robes for a single robe – the floating-point number in the range [0.00…100.00].
        //•	The price of belts for a single belt – the floating-point number in the range [0.00…100.00].

        double moneyHave = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsablerPrice = Double.parseDouble(scanner.nextLine());
        double roberPrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        //Because the lightsabers sometimes break, George Lucas should buy 10% more,rounded up to the next integer.
        // Also, every sixth belt is free.
        double totalLightsablersPrice = lightsablerPrice * (students + Math.ceil(students * 0.1));
        double totalRobersPrice = roberPrice * students;
        int freeBelts = (students / 6);
        double totalBeltsPrice = beltPrice * (students - freeBelts);
        double total = totalLightsablersPrice + totalRobersPrice + totalBeltsPrice;

        //•	If the calculated price of the equipment is less or equal to the money George Lucas has:
        //"The money is enough - it would cost {the cost of the equipment}lv."
        //•	If the calculated price of the equipment is more than the money George Lucas has:
        // "George Lucas will need {neededMoney}lv more."
        if (moneyHave >= total) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", total - moneyHave);
        }


    }
}
