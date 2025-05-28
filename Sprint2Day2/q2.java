import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class DepartmentCount {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "HR"),
            new Employee("Jane", "IT"),
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Eve", "Finance"),
            new Employee("Mike", "IT")
        );

        Map<String, Long> departmentCounts = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
            ));

        System.out.println(departmentCounts);
    }
}
