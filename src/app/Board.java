package app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Board extends JFrame {

    public Board() {
        setTitle("Dashboard - User Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("User's List", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/board.png"));
        Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(scaled));
        picLabel.setHorizontalAlignment(JLabel.CENTER);
        add(picLabel, BorderLayout.WEST);

        String[] columnNames = {"ID", "Username", "Fullname", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(e -> System.exit(0));
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(exitBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        loadUsers(model);

        setVisible(true);
    }

    private void loadUsers(DefaultTableModel model) {
        try (Connection c = DatabaseConnection.getConnection();
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT user_id, username, fullname, email FROM users")) {

            while (rs.next()) {
                Object[] row = {
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("fullname"),
                        rs.getString("email")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading users: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Board();
    }
}
