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

    public static void searchProducts(String category, Double minPrice, Double maxPrice) {
        Connection conn = getConnection();

        if (conn == null) return;

        StringBuilder query = new StringBuilder("SELECT * FROM products WHERE 1=1");
        try {
            if (category != null && !category.isEmpty()) {
                query.append(" AND category = ?");
            }
            if (minPrice != null) {
                query.append(" AND price >= ?");
            }
            if (maxPrice != null) {
                query.append(" AND price <= ?");
            }

            PreparedStatement stmt = conn.prepareStatement(query.toString());

            int paramIndex = 1;
            if (category != null && !category.isEmpty()) {
                stmt.setString(paramIndex++, category);
            }
            if (minPrice != null) {
                stmt.setDouble(paramIndex++, minPrice);
            }
            if (maxPrice != null) {
                stmt.setDouble(paramIndex++, maxPrice);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Price: " + rs.getDouble("price"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        searchProducts("Electronics", 500.0, 1500.0);
    }
}
