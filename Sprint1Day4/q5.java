import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {

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

    public static void getStudentCourses(int studentId) {
        String query = "SELECT c.course_name, c.instructor, e.grade " +
                       "FROM students s " +
                       "JOIN enrollments e ON s.id = e.student_id " +
                       "JOIN courses c ON e.course_id = c.id " +
                       "WHERE s.id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Courses for Student ID: " + studentId);
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                String instructor = rs.getString("instructor");
                String grade = rs.getString("grade");

                System.out.println("Course: " + courseName +
                                   ", Instructor: " + instructor +
                                   ", Grade: " + grade);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving student courses: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();

        if (connection != null) {
            getStudentCourses(1); 

            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
