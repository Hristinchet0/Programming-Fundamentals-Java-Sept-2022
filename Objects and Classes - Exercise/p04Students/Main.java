package p04Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();

        for (int studentCount = 1; studentCount <= countStudents; studentCount++) {
            String data = scanner.nextLine();
            //"{first name} {second name} {grade}"
            String[] dataParts = data.split(" ");
            String firstName = dataParts[0];
            String lastName = dataParts[1];
            double grade = Double.parseDouble(dataParts[2]);

            Student student = new Student(firstName, lastName, grade);
            studentList.add(student);
        }

        //списък със студенти -> сортиране на списъка от висока към ниска оценка
        studentList.sort(Comparator.comparing(Student::getGrade).reversed());
        //да отпечатаме всеки един студент
        for (Student student : studentList) {
            System.out.println(student);
        }

    }
}
