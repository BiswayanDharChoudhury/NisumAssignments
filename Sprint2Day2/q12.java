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

public class GenderSeparator {
    public static String separateByGender(List<Employee> employees) {
        Map<String, List<String>> genderMap = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.getGender().toUpperCase(),
                Collectors.mapping(Employee::getName, Collectors.toList())
            ));

        String maleNames = genderMap.getOrDefault("MALE", Collections.emptyList())
                .stream().collect(Collectors.joining("-"));
        String femaleNames = genderMap.getOrDefault("FEMALE", Collections.emptyList())
                .stream().collect(Collectors.joining("-"));

        return String.format("MALE: [%s], FEMALE: [%s]", maleNames, femaleNames);
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "Male"),
            new Employee("Mike", "Male"),
            new Employee("Alice", "Female"),
            new Employee("Lily", "Female")
        );

        String result = separateByGender(employees);
        System.out.println(result); 
    }
}
