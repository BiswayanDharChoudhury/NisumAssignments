import java.util.Optional;

class Employee {
    private final int empId;
    private final String name;
    private final Optional<String> email;
    private final Optional<String> phone;

    public Employee(int empId, String name, String email, String phone) {
        this.empId = empId;
        this.name = name;
        this.email = Optional.ofNullable(email);
        this.phone = Optional.ofNullable(phone);
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public Optional<String> getEmail() { return email; }
    public Optional<String> getPhone() { return phone; }

    public String getDetails() {
        return "ID: " + empId +
               ", Name: " + name +
               ", Email: " + email.orElse("N/A") +
               ", Phone: " + phone.orElse("N/A");
    }
}

public class EmployeeOptionalDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Alice", "alice@example.com", null);
        Employee emp2 = new Employee(102, "Bob", null, "123-456-7890");
        Employee emp3 = new Employee(103, "Carol", null, null);

        System.out.println(emp1.getDetails());
        System.out.println(emp2.getDetails());
        System.out.println(emp3.getDetails());

        emp1.getEmail().ifPresent(email -> System.out.println("Alice's email: " + email));
        emp2.getPhone().ifPresent(phone -> System.out.println("Bob's phone: " + phone));
    }
}
