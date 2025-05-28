import java.util.*;
import java.util.Optional;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return name + " (" + department + "): $" + salary;
    }
}

public class SalaryIncreaseDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("John", "IT", 50000),
            new Employee("Alice", "HR", 60000),
            new Employee("Bob", "IT", 45000),
            new Employee("Eve", null, 55000) 
        ));

        employees.forEach(emp ->
            Optional.ofNullable(emp.getDepartment()) 
                .filter(dept -> dept.equalsIgnoreCase("IT")) 
                .ifPresent(dept -> emp.setSalary(emp.getSalary() * 1.1)) 
        );

        employees.forEach(System.out::println);
    }
}
