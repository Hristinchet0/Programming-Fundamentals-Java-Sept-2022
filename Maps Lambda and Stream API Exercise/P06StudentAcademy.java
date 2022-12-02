import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGrade = new LinkedHashMap<>();
        //студент -> списък с всички оценки

        int countStudents = Integer.parseInt(scanner.nextLine());
        for (int student = 1; student <= countStudents; student++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            //1.ако не е записан
            if (!studentsGrade.containsKey(name)) {
                studentsGrade.put(name, new ArrayList<>()); // записваме студента, създаваме лист за да пази оценките
            } //2.ако е записан
            studentsGrade.get(name).add(grade); // взимаме списъка с оценките за студента и добавяме оценките

        }
        //Вече имам Map с име на студента -> списък с неговите оценки
        //името на студента -> средната оценка
        Map<String, Double> averageGradeStudents = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : studentsGrade.entrySet()) {
            String studentName = entry.getKey(); // името на студента
            List<Double> listGrades = entry.getValue(); //списъка с оценките за всеки студент
            double averageGrade = getAverageGrade(listGrades); //средна ценка
            if (averageGrade >= 4.50) { //ако оценката на студента е >= 4,50, добави го в averageGradeStudents
                averageGradeStudents.put(studentName, averageGrade);
            }
        }
        //отпечатваме averageGradeStudents
        averageGradeStudents.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));

    }

    private static double getAverageGrade(List<Double> listGrades) {
        //средно аритметична оценка на листа от оценки на студента
        double sumGrade = 0;
        for (double grade : listGrades) {
            sumGrade += grade;
        }
        return sumGrade / listGrades.size();
    }
}
