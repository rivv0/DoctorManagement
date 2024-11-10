package gui;

import dao.DoctorDAO;
import models.Doctor;

import javax.swing.*;
import java.awt.*;

public class ManageDoctorsFrame extends JFrame {
    public ManageDoctorsFrame() {
        setTitle("Manage Doctors");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Name input
        JLabel lblName = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(lblName, gbc);

        JTextField txtName = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(txtName, gbc);

        // Specialization input
        JLabel lblSpecialization = new JLabel("Specialization:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblSpecialization, gbc);

        JTextField txtSpecialization = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(txtSpecialization, gbc);

        // Email input
        JLabel lblEmail = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblEmail, gbc);

        JTextField txtEmail = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(txtEmail, gbc);

        // Phone input
        JLabel lblPhone = new JLabel("Phone:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(lblPhone, gbc);

        JTextField txtPhone = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(txtPhone, gbc);

        // Add Doctor button
        JButton btnAddDoctor = new JButton("Add Doctor");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnAddDoctor, gbc);

        btnAddDoctor.addActionListener(e -> {
            String name = txtName.getText();
            String specialization = txtSpecialization.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();

            Doctor newDoctor = new Doctor(name, specialization, email, phone);
            DoctorDAO doctorDAO = new DoctorDAO();
            doctorDAO.addDoctor(newDoctor);
            JOptionPane.showMessageDialog(null, "Doctor added: " + name);

            // Clear the input fields
            txtName.setText("");
            txtSpecialization.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
        });

        add(mainPanel);
        setVisible(true);
    }
}