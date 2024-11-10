package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.PatientDAO;
import models.Patient;

public class ManagePatientsFrame extends JFrame {
    
    public ManagePatientsFrame() {
        setTitle("Manage Patients");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(10, 20, 80, 25);
        add(lblFullName);
        
        JTextField txtFullName = new JTextField(20);
        txtFullName.setBounds(100, 20, 165, 25);
        add(txtFullName);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 50, 80, 25);
        add(lblUsername);
        
        JTextField txtUsername = new JTextField(20);
        txtUsername.setBounds(100, 50, 165, 25);
        add(txtUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 80, 80, 25);
        add(lblPassword);
        
        JPasswordField txtPassword = new JPasswordField(20);
        txtPassword.setBounds(100, 80, 165, 25);
        add(txtPassword);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 110, 80, 25);
        add(lblEmail);
        
        JTextField txtEmail = new JTextField(20);
        txtEmail.setBounds(100, 110, 165, 25);
        add(txtEmail);
        
        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(10, 140, 80, 25);
        add(lblPhone);
        
        JTextField txtPhone = new JTextField(20);
        txtPhone.setBounds(100, 140, 165, 25);
        add(txtPhone);
        
        JButton btnAddPatient = new JButton("Add Patient");
        btnAddPatient.setBounds(10, 180, 150, 25);
        add(btnAddPatient);
        
        btnAddPatient.addActionListener(e -> {
            String fullName = txtFullName.getText();
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String email = txtEmail.getText();
            String phone = txtPhone.getText();

            Patient newPatient = new Patient(username, password, fullName, email, phone); // Removed patientId
            PatientDAO patientDAO = new PatientDAO();
            patientDAO.addPatient(newPatient);
            JOptionPane.showMessageDialog(null, "Patient added: " + fullName);
        });
        
        setVisible(true);
    }
}

