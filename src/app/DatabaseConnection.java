package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_NAME = "user_management";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Halilcetin42."; // your password

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Database connected!");
            } catch (ClassNotFoundException e) {
                System.err.println("❌ JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("❌ Connection failed: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
