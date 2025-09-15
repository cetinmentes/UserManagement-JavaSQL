package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUser {

    
    public static boolean register(String fullname, String username, String password, String phone, String email) {
        Connection c = DatabaseConnection.getConnection();
        if (c == null) return false;

        
        String sql = "INSERT INTO users (fullname, username, password, phone, email) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, fullname);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, phone);
            stmt.setString(5, email);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.err.println("❌ SQL Error: " + e.getMessage());
            return false;
        }
    }

    // deneme
    public static void main(String[] args) {
        boolean success = register(
                "Karin Müller",   
                "karin55",        
                "1234",           
                "5551112233",    
                "karin@test.com" 
        );

        if (success) {
            System.out.println("✅ Registration is complete!");
        } else {
            System.out.println("❌ Registration failed!");
        }
    }
}
