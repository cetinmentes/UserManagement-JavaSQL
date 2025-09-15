package app;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register2 extends JFrame {

    private JTextField fullnameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField passwordField;

    public Register2() {
        setTitle("Register Form");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Create a New Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/register.png"));
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(imageLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel fullnameLabel = new JLabel("Full Name:");
        fullnameField = new JTextField(15);
        centerPanel.add(fullnameLabel);
        centerPanel.add(fullnameField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        centerPanel.add(usernameLabel);
        centerPanel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(15);
        centerPanel.add(emailLabel);
        centerPanel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField(15);
        centerPanel.add(phoneLabel);
        centerPanel.add(phoneField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);

        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(e -> {
            String fullname = fullnameField.getText();
            String username = usernameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String password = new String(passwordField.getPassword());

            if (registerUser(fullname, username, email, phone, password)) {
                JOptionPane.showMessageDialog(this,
                        "Registration successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Registration failed!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new HomePage();
        });

        setVisible(true);
    }

    private boolean registerUser(String fullname, String username, String email, String phone, String password) {
        Connection c = DatabaseConnection.getConnection();
        if (c == null) return false;

        String sql = "INSERT INTO users (fullname, username, email, phone, password) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, fullname);
            stmt.setString(2, username);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, password);

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new Register2();
    }
}
