import java.sql.*;

// Student class to hold student information
class Student {
    private int id;
    private String name;
    private String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters (you can add setters if needed)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}

public class Student2 {

    // Method to establish JDBC connection
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "LEYBs5x4";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    // Method to retrieve a student by ID
    public static Student getStudentById(int studentId) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Connection conn = getConnection();

        if (conn == null) return null;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");

                return new Student(id, name, dept);
            } else {
                System.out.println("Student not found.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int testStudentId = 1; 
        Student student = getStudentById(testStudentId);

        if (student != null) {
            System.out.println("Student Found: " + student);
        }
    }
}
