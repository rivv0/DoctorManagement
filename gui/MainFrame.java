package gui;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
    private BufferedImage backgroundImage;
    private ViewDoctorsFrame viewDoctorsFrame;

    public MainFrame() {
        try {
            backgroundImage = ImageIO.read(new File("src/images/img2.jpg"));
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

        setTitle("Doctor Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        backgroundPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

        JButton btnViewDoctors = createStyledButton("View Doctors");
        JButton btnManagePatients = createStyledButton("Manage Patients");
        JButton btnManageDoctors = createStyledButton("Manage Doctors");
        JButton btnManageAppointments = createStyledButton("Manage Appointments");
        

        btnViewDoctors.addActionListener(e -> showViewDoctorsFrame());
        btnManagePatients.addActionListener(e -> new ManagePatientsFrame());
        btnManageDoctors.addActionListener(e -> showManageDoctorsFrame());

        btnManageAppointments.addActionListener(e -> new ManageAppointmentsFrame());

        buttonPanel.add(btnViewDoctors);
        buttonPanel.add(btnManagePatients);
        buttonPanel.add(btnManageDoctors);
        buttonPanel.add(btnManageAppointments);

        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(backgroundPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showViewDoctorsFrame() {
        if (viewDoctorsFrame == null) {
            viewDoctorsFrame = new ViewDoctorsFrame();
        }
        viewDoctorsFrame.setVisible(true);
    }
    private void showManageDoctorsFrame() {
        new ManageDoctorsFrame().setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 40));

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}