package p01CompanyRoster;

import java.util.List;

public class Department {

    String name;
    List<Employee> employeeList;
    double averageSalary;

    List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public Department(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
        this.averageSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0.00);
    }

    double getAverageSalary() {
        return this.averageSalary;
    }

    public String getName() {
        return this.name;
    }
}
