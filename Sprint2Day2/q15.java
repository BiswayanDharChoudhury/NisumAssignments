import java.util.Optional;

class Employee {
    private final int empId;
    private final String name;
    private final Optional<String> address;

    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = Optional.ofNullable(address);
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public Optional<String> getAddress() { return address; }

    public String getDetails() {
        String defaultAddress = "No Address Provided";
        return "ID: " + empId +
               ", Name: " + name +
               ", Address: " + address.orElse(defaultAddress);
    }
}

public class EmployeeOptionalAddressDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Alice", "123 Main St");
        Employee emp2 = new Employee(102, "Bob", null);

        System.out.println(emp1.getDetails());
        System.out.println(emp2.getDetails());
    }
}
