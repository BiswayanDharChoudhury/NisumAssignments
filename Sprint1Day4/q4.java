import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagement {
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

    // Method to transfer credits from one student to another as a transaction
    public static boolean transferCredits(int fromStudentId, int toStudentId, int amount) {
        String deductSQL = "UPDATE students SET credits = credits - ? WHERE id = ?";
        String addSQL = "UPDATE students SET credits = credits + ? WHERE id = ?";

        Connection connection = getConnection();

        if (connection == null) return false;

        try {
            // Start transaction
            connection.setAutoCommit(false);

            try (PreparedStatement deductStmt = connection.prepareStatement(deductSQL);
                 PreparedStatement addStmt = connection.prepareStatement(addSQL)) {

                // Deduct credits from sender
                deductStmt.setInt(1, amount);
                deductStmt.setInt(2, fromStudentId);
                int rowsDeducted = deductStmt.executeUpdate();

                // Add credits to receiver
                addStmt.setInt(1, amount);
                addStmt.setInt(2, toStudentId);
                int rowsAdded = addStmt.executeUpdate();

                // Check if both operations succeeded
                if (rowsDeducted == 1 && rowsAdded == 1) {
                    connection.commit();  // Commit transaction
                    System.out.println("Transaction successful: " + amount + " credits transferred.");
                    return true;
                } else {
                    connection.rollback();  // Rollback if any operation fails
                    System.err.println("Transaction failed: Rows not affected correctly.");
                    return false;
                }

            } catch (SQLException e) {
                connection.rollback();  // Rollback on exception
                System.err.println("Transaction failed, rolled back: " + e.getMessage());
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Transaction error: " + e.getMessage());
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);  // Restore default mode
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        transferCredits(1, 2, 10);
    }
}
