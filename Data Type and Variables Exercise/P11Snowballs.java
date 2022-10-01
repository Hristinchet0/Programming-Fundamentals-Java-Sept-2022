import java.math.BigInteger;
import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberSnawballs = Integer.parseInt(scanner.nextLine());
        long maxSnowballValue = 0;
        String bestResult = "";

        for (int i = 1; i <= numberSnawballs; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long snowballValue  = (long) Math.pow(snowballSnow / snowballTime, snowballQuality);

            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                String result =  String.format("%d : %d = %d (%d)", snowballSnow, snowballTime, maxSnowballValue, snowballQuality);
                bestResult = result;
            }
        }
        System.out.println(bestResult);
    }
}
