import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double grade;

    Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

public class q2 {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void addStudent(int id, String name, double grade) {
        studentList.add(new Student(id, name, grade));
        System.out.println("Student has been added.");
    }

    public static void deleteStudent(int id) {
        boolean isFound = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == id) {
                studentList.remove(i);
                System.out.println("Student has been removed.");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No student found with ID " + id);
        }
    }

    public static void findStudent(int id) {
        for (Student s : studentList) {
            if (s.id == id) {
                System.out.println("Student found: " + s);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public static void showAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty.");
        } else {
            System.out.println("\nCurrent Students:");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Search for a Student by ID");
            System.out.println("4. View All Students");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice (1-5): ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Student ID: ");
                    int id = input.nextInt();
                    input.nextLine(); // clean newline
                    System.out.print("Student Name: ");
                    String name = input.nextLine();
                    System.out.print("Student Grade: ");
                    double grade = input.nextDouble();
                    addStudent(id, name, grade);
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    int removeId = input.nextInt();
                    deleteStudent(removeId);
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = input.nextInt();
                    findStudent(searchId);
                    break;

                case 4:
                    showAllStudents();
                    break;

                case 5:
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Please enter a number from 1 to 5.");
            }

        } while (choice != 5);

        input.close();
    }
}
