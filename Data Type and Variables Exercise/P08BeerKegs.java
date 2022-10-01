import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни
        //за всеки кег
        //1.прочитаме данните
        //2. обем = π * r^2 (Math.pow(r, 2) * h
        //3. проверка дали ми е най-големия кег

        //търсим максимална стойност
        //1.променлива в която съхраняваме нашият максимум
        double maxVolume = Double.MIN_VALUE;
        String maxModelKeg = ""; //променлива която да държи името на най-големия кег
        int countKegs = Integer.parseInt(scanner.nextLine());
        for (int keg = 1; keg <= countKegs ; keg++) {
            String kegModel = scanner.nextLine();
            double radiusKeg = Double.parseDouble(scanner.nextLine());
            int heightKeg = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radiusKeg, 2) * heightKeg;
            //2. проверка дали дадения обем е по-голям от максималния
            if (volume > maxVolume) {
                maxVolume = volume;
                maxModelKeg = kegModel;
            }
        }
        System.out.println(maxModelKeg);



    }
}
