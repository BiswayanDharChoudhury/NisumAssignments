import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}

public class SalarySorter {
    public static List<Employee> sortBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 50000),
            new Employee("Alice", 65000),
            new Employee("Bob", 40000),
            new Employee("Eve", 70000)
        );

        List<Employee> sorted = sortBySalary(employees);
        sorted.forEach(System.out::println);
    }
}
