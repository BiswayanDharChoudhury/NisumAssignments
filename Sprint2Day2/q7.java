import java.util.*;
import java.util.stream.*;

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

public class MaxEmpIdFinder {
    public static Optional<Employee> findEmployeeWithMaxEmpId(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getEmpId));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(102, "John"),
            new Employee(205, "Alice"),
            new Employee(150, "Bob")
        );

        Optional<Employee> maxEmp = findEmployeeWithMaxEmpId(employees);
        maxEmp.ifPresent(System.out::println);
    }
}
