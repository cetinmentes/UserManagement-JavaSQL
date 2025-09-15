package app;

import javax.swing.*;
import java.awt.*;

public class Login2 extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login2() {
        setTitle("Welcome");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Login to Your Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/login.png"));
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(imageLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel userLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        centerPanel.add(userLabel);
        centerPanel.add(usernameField);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel passLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        centerPanel.add(passLabel);
        centerPanel.add(passwordField);

        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        buttonPanel.add(loginButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (Login.login(username, password)) {
                JOptionPane.showMessageDialog(Login2.this,
                        "Login successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                new Board();
                dispose();
            } else {
                JOptionPane.showMessageDialog(Login2.this,
                        "Wrong username or password!",
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

    public static void main(String[] args) {
        new Login2();
    }
}
