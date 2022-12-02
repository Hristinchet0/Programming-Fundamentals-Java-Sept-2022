package p01CompanyRoster;

import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String input = scanner.nextLine();
            //name, salary, position, department, email, and age.
            String[] inputArr = input.split("\\s+");
            Employee employee = new Employee();
            employee.setName(inputArr[0]);
            employee.setSalary(Double.parseDouble(inputArr[1]));
            employee.setPosition(inputArr[2]);
            employee.setDepartment(inputArr[3]);

            if (inputArr.length == 5) {
                if (inputArr[4].contains("@")) {
                    employee.setEmail(inputArr[4]);
                } else {
                    employee.setAge(Integer.parseInt(inputArr[4]));
                }
            }

            if (inputArr.length == 6) {
                if (inputArr[4].contains("@")) {
                    employee.setEmail(inputArr[4]);
                    employee.setAge(Integer.parseInt(inputArr[5]));
                } else {
                    employee.setAge(Integer.parseInt(inputArr[5]));
                    employee.setEmail(inputArr[4]);

                }
            }


            employees.add(employee);
        }

        List<String> departmentsList = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        List<Department> departments = new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department,
                    employees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAverageSalary).reversed());
        Department department = departments.get(0);
        department.getEmployeeList().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployeeList()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }


    }
}
