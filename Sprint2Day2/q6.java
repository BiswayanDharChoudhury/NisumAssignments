import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class EmployeeSorter {
    public static List<Employee> sortByFirstName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "Doe"),
            new Employee("Alice", "Smith"),
            new Employee("Bob", "Johnson")
        );

        List<Employee> sorted = sortByFirstName(employees);
        sorted.forEach(System.out::println);
    }
}
