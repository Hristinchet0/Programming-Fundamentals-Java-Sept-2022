import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06Students2 {
    static class Student {
        String firstName;
        String lastName;
        int age;
        String town;

        Student() {
            this.firstName = null;
            this.lastName = null;
            this.age = 0;
            this.town = null;
        }

        public Student(String firstName, String lastName, int age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getTown() {
            return this.town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old%n",
                    this.getFirstName(),
                    this.getLastName(),
                    this.getAge());
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        String inputLine = scanner.nextLine();


        while (!inputLine.equals("end")) {
            String[] arrStudentData = inputLine.split("\\s+");

            String firstName = arrStudentData[0];
            String lastName = arrStudentData[1];
            int age = Integer.parseInt(arrStudentData[2]);
            String town = arrStudentData[3];

            Student currentStudent = new Student(firstName, lastName, age, town);
            int existingIndex = findStudentsIndex(studentList, currentStudent.getFirstName(), currentStudent.getLastName());

            if (existingIndex != -1) {
                studentList.get(existingIndex).setAge(currentStudent.getAge());
                studentList.get(existingIndex).setTown(currentStudent.getTown());
            } else {
                studentList.add(currentStudent);
            }

            inputLine = scanner.nextLine();
        }

        String homeTown = scanner.nextLine();

        for (Student item : studentList) {
            if (item.getTown().equals(homeTown)) {
                System.out.print(item);
            }
        }

    }

    static public int findStudentsIndex(List<Student> studentList, String firstName, String lastName) {
        for (int i = 0; i < studentList.size(); i++) {
            String firstNameList = studentList.get(i).getFirstName();
            String lastNameLIst = studentList.get(i).getLastName();

            if (firstNameList.equals(firstName) && lastNameLIst.equals(lastName)) {
                return i;
            }
        }
        return -1;
    }
}
