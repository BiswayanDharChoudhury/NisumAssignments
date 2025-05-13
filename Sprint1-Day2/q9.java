import java.util.*;


class Student {
    private String name;
    private String address;
    private String section;
    private String className;
    private static int rollNo;
    private static String college;
    
    
    static{
        college = "Kalinga Institute of Industrial Technology";
    }

    // Constructor
    public Student(String name, String address, String section, String className, int rollNo, String college) {
        this.name = name;
        this.address = address;
        this.section = section;
        this.className = className;
        this.rollNo = rollNo ; 
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Section: " + section);
        System.out.println("Class: " + className);
        System.out.println("Roll No: " + rollNo);
        System.out.println("College: " + college);
        System.out.println("--------------------------------");
    }
}

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Student s1 = new Student("Alice", "Bhubaneswar", "A", "3rd Year", 2205978, "KIIT");
        Student s2 = new Student("Bob", "Cuttack", "B", "3rd Year", 2205980, "IIT Delhi");

        s1.displayStudentInfo();
        s2.displayStudentInfo();
    }
}
