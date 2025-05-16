import java.sql.*;

// Student class to hold student information
class Student3 {
    private int id;
    private String name;
    private String department;

    public Student3(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters 
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

public class Crud {

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

    // Method to insert a new student
    public static boolean insertStudent(Student student) {
        String sql = "INSERT INTO students (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getDepartment());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
            return false;
        }
    }

    // Method to update an existing student
    public static boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getDepartment());
            stmt.setInt(3, student.getId());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    // Method to delete a student by ID
    public static boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
            return false;
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

    // Main method to test insert, update, and delete
    public static void main(String[] args) {
        Student newStudent = new Student(3, "Ravi Kumar", "Physics");

        // Insert
        if (insertStudent(newStudent)) {
            System.out.println("Student inserted successfully.");
        }

        // Update
        Student updatedStudent = new Student(3, "Ravi Kumar", "Mathematics");
        if (updateStudent(updatedStudent)) {
            System.out.println("Student updated successfully.");
        }

        // Delete
        if (deleteStudent(3)) {
            System.out.println("Student deleted successfully.");
        }
    }
}
