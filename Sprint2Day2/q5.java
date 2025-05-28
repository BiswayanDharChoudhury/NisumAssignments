import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
}

public class EmployeeFilter {
    public static List<Employee> excludeDepartment(List<Employee> employees, String excludedDept) {
        return employees.stream()
                .filter(emp -> !emp.getDepartment().equalsIgnoreCase(excludedDept))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "HR"),
            new Employee("Jane", "IT"),
            new Employee("Alice", "HR"),
            new Employee("Bob", "Finance")
        );

        List<Employee> result = excludeDepartment(employees, "HR");
        result.forEach(emp -> System.out.println(emp.getName() + " - " + emp.getDepartment()));
    }
}
