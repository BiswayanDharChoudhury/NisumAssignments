import java.util.*;

class Employee {
    private String firstName;
    private String lastName;
    private String department;

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDepartment() { return department; }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

public class EmployeeFetcher {
    public static Optional<String> getEighthEmployeeInfo(List<Employee> employees) {
        if (employees.size() < 8) {
            return Optional.empty(); // Less than 8 employees
        }
        Employee emp = employees.get(7); // 0-based index, so 7 is the 8th employee
        String info = emp.getFullName() + " - " + emp.getDepartment();
        return Optional.of(info);
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "Doe", "HR"),
            new Employee("Alice", "Smith", "IT"),
            new Employee("Bob", "Johnson", "Finance"),
            new Employee("Eve", "Williams", "Marketing"),
            new Employee("Charlie", "Brown", "IT"),
            new Employee("Diana", "Clark", "HR"),
            new Employee("Frank", "Miller", "Finance"),
            new Employee("Grace", "Lee", "IT"),   
            new Employee("Hank", "Wilson", "Marketing"),
            new Employee("Ivy", "Taylor", "HR")
        );

        Optional<String> eighthEmployeeInfo = getEighthEmployeeInfo(employees);
        eighthEmployeeInfo.ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Less than 8 employees in the list")
        );
    }
}
