import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeEfficiency1 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency2 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency3 = Integer.parseInt(scanner.nextLine());
        int studentsCountForTheDay = Integer.parseInt(scanner.nextLine());

        int totalEmployeeEfficiency =  employeeEfficiency1 + employeeEfficiency2 + employeeEfficiency3;
        int neededHours = 0;

        while (studentsCountForTheDay > 0) { //докато студентите са повече от 0 ->
            studentsCountForTheDay -= totalEmployeeEfficiency; // изваждай обслужените студенти ->
            neededHours++; // и ми добавяй по 1 час

            if ((neededHours & 3) == 0) { //време за почивка на всеки 3 часа. Ако часовете са станали 3 ->
                neededHours++; // добави ми 1 час почивка.
            }
        }

        System.out.printf("Time needed: %dh.", neededHours);

    }
}
