package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    public static boolean login(String username, String password) {
        Connection c = DatabaseConnection.getConnection();
        if (c == null) return false;

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); 

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (login(user, pass)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed: Wrong username or password.Try again.");
        }

        sc.close();
    }
}
