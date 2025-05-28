import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return empId + " - " + name;
    }
}

public class EmployeeMatcher {
    public static List<Employee> getMatchingEmployees(List<Integer> idList, List<Employee> allEmployees) {
        Set<Integer> idSet = new HashSet<>(idList); 
        return allEmployees.stream()
                .filter(emp -> idSet.contains(emp.getEmpId()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> allEmployees = Arrays.asList(
            new Employee(101, "John"),
            new Employee(102, "Alice"),
            new Employee(103, "Bob"),
            new Employee(104, "Eve"),
            new Employee(105, "Grace")
        );

        List<Integer> idList = Arrays.asList(102, 104, 999);

        List<Employee> result = getMatchingEmployees(idList, allEmployees);
        result.forEach(System.out::println); 
    }
}
