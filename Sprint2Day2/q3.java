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

public class EmployeeSearch {
    public static List<Employee> filterEmployees(
        Map<String, List<Employee>> departmentMap, 
        String searchString
    ) {
        if (searchString == null || searchString.isEmpty()) {
            return Collections.emptyList(); 
        }

        String searchLower = searchString.toLowerCase();
        
        return departmentMap.values().stream()
            .flatMap(List::stream) 
            .filter(employee -> 
                employee.getFirstName().toLowerCase().contains(searchLower) ||
                employee.getLastName().toLowerCase().contains(searchLower)
            )
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
       
        Map<String, List<Employee>> departments = new HashMap<>();
        departments.put("HR", Arrays.asList(
            new Employee("John", "Doe"),
            new Employee("Alice", "Smith")
        ));
        departments.put("IT", Arrays.asList(
            new Employee("Bob", "Johnson"),
            new Employee("Eve", "Anderson")
        ));

        List<Employee> result = filterEmployees(departments, "an");
        result.forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName()));
    }
}
