import java.util.Scanner;
import java.util.TreeSet;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

public class q6 {
    private static final TreeSet<Employee> employeeSet = new TreeSet<>();

    // Add new employee
    public static void addEmployee(int id, String name, String department, double salary) {
        Employee newEmployee = new Employee(id, name, department, salary);
        if (employeeSet.add(newEmployee)) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee already exists or duplicate name.");
        }
    }

    // Display all employees in sorted order
    public static void showAllEmployees() {
        if (employeeSet.isEmpty()) {
            System.out.println("No employee records available.");
        } else {
            System.out.println("\nEmployee Records (Sorted by Name):");
            for (Employee emp : employeeSet) {
                System.out.println(emp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    addEmployee(id, name, department, salary);
                    break;

                case 2:
                    showAllEmployees();
                    break;

                case 3:
                    System.out.println("Exiting Employee Records System.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
