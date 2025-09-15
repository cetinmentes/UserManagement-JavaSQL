package app;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("User Management System");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Welcome to User Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/homepage.jpg"));
        Image scaled = icon.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton registerBtn = new JButton("Register");
        registerBtn.setBackground(new Color(70, 130, 180));
        registerBtn.setForeground(Color.WHITE);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(60, 179, 113));
        loginBtn.setForeground(Color.WHITE);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBackground(new Color(220, 20, 60));
        exitBtn.setForeground(Color.WHITE);

        registerBtn.addActionListener(e -> {
            dispose();
            new Register2();
        });

        loginBtn.addActionListener(e -> {
            dispose();
            new Login2();
        });

        exitBtn.addActionListener(e -> System.exit(0));

        buttonPanel.add(registerBtn);
        buttonPanel.add(loginBtn);
        buttonPanel.add(exitBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
