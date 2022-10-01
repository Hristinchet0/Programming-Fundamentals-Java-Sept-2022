import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int factor = Integer.parseInt(scanner.nextLine());
        //Повтаряме
        int countPoke = 0;
        int firstPower = powerN;
        while (powerN >= distanceM) {
            //1.power -= distance -> poke++
            powerN -= distanceM;
            countPoke ++;
            //2.проверка за умората
            if (powerN == firstPower / 2) {
                if (factor != 0) {
                    powerN = powerN / factor;
                }
            }
            //stop: power < distance
            //продължава power >= distance
        }
        System.out.println(powerN);
        System.out.println(countPoke);

    }
}
