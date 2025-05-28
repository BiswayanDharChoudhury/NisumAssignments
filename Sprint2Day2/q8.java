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
}

public class EmployeeNameConcatenator {
    public static String concatenateEmployeeNames(List<Employee> employees) {
        return employees.stream()
                .map(emp -> emp.getFirstName() + " " + emp.getLastName())
                .collect(Collectors.joining("|"));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "Doe"),
            new Employee("Alice", "Smith"),
            new Employee("Bob", "Johnson")
        );

        String result = concatenateEmployeeNames(employees);
        System.out.println(result); 
    }
}
