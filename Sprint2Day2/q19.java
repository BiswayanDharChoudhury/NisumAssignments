import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    public Employee(String name) { this.name = name; }
    public String getName() { return name; }
    @Override
    public String toString() { return name; }
}

public class FindEmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John"),
            new Employee("Alice"),
            new Employee("Bob")
        );

        Optional<Employee> firstEmp = employees.stream().findFirst();
        firstEmp.ifPresent(emp -> System.out.println("First Employee: " + emp));

        Optional<Employee> anyEmp = employees.stream().findAny();
        anyEmp.ifPresent(emp -> System.out.println("Any Employee: " + emp));
    }
}
