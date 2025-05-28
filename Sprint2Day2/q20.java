import java.util.*;

class Employee {
    private String name;
    private String department;
    private String email;

    public Employee(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
}

public class MatchDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "HR", "john@company.com"),
            new Employee("Alice", "IT", "alice@company.com"),
            new Employee("Bob", "Finance", "bob@company.com"),
            new Employee(null, "HR", "eve@company.com"),
            new Employee("Eve", "HR", null)
        );

        boolean anyFromHR = employees.stream()
                .anyMatch(emp -> "HR".equalsIgnoreCase(emp.getDepartment()));

       
        boolean allHaveEmail = employees.stream()
                .allMatch(emp -> emp.getEmail() != null);

        
        boolean noneNullName = employees.stream()
                .noneMatch(emp -> emp.getName() == null);

        System.out.println("Any employee from HR? " + anyFromHR);           
        System.out.println("All employees have email? " + allHaveEmail);    
        System.out.println("No employee has null name? " + noneNullName);   
    }
}
