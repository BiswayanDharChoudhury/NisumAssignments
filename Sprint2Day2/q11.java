import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String gender;

    public Employee(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getGender() { return gender; }
    public String getName() { return name; }
}

public class GenderGrouping {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "Male"),
            new Employee("Alice", "Female"),
            new Employee("Bob", "Male"),
            new Employee("Eve", "Female"),
            new Employee("Grace", "Female")
        );

        Map<String, Long> genderCounts = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.counting()
            ));

        System.out.println(genderCounts); 
    }
}
