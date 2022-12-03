import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double lectures = Double.parseDouble(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        double maxLectures = 0;

        for (int i = 0; i < students; i++) {
            {
                int studentAttendance = Integer.parseInt(scanner.nextLine());
                double totalBonus = Math.ceil(studentAttendance / lectures * (5 + bonus));

                if (totalBonus >= maxBonus) {
                    maxBonus = totalBonus;
                    maxLectures = studentAttendance;

                }
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %.0f lectures.", maxLectures);
    }
}
