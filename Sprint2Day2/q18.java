import java.util.*;
import java.util.stream.Collectors;

class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() { return city; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private Address address;

    public Employee(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Address getAddress() { return address; }
}

public class EmployeeAddressMap {
    public static Map<String, Address> getEmployeeAddressMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                    emp -> emp.getFirstName() + emp.getLastName(),
                    Employee::getAddress
                ));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "Doe", new Address("Paris", "France")),
            new Employee("Alice", "Smith", new Address("Berlin", "Germany")),
            new Employee("Bob", "Johnson", new Address("Munich", "Germany"))
        );

        Map<String, Address> map = getEmployeeAddressMap(employees);

        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
