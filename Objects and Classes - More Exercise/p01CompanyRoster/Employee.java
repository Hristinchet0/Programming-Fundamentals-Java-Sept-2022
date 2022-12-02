package p01CompanyRoster;

public class Employee {
    //Define a class Employee with the following information:
    // name, salary, position, department, email, and age.
    // The name, salary, position, and department are mandatory, while the rest are optional.

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    Employee() {
        this.email = "n/a";
        this.age = -1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
