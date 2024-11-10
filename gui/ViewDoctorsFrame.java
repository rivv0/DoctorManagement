package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewDoctorsFrame extends JFrame {
    private JTable doctorsTable;
    private DefaultTableModel tableModel;

    public ViewDoctorsFrame() {
        setTitle("View Doctors");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        loadDoctorsData();
    }

    private void initComponents() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Table for displaying doctors
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Doctor ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Specialization");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone");

        doctorsTable = new JTable(tableModel);
        doctorsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(doctorsTable);
        contentPanel.add(scrollPane);

        add(contentPanel);
    }

    private void loadDoctorsData() {
        List<Doctor> doctors = getDoctorsFromDatabase();

        // Clear the table model
        tableModel.setRowCount(0);

        // Populate the table with doctors data
        for (Doctor doctor : doctors) {
            Object[] rowData = {
                doctor.getDoctorId(),
                doctor.getName(),
                doctor.getSpecialization(),
                doctor.getEmail(),
                doctor.getPhone()
            };
            tableModel.addRow(rowData);
        }
    }

    private List<Doctor> getDoctorsFromDatabase() {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = getDBConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctors");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
            	
        	    String name = resultSet.getString("name"); // Assuming column name is 'name'
        	    String specialization = resultSet.getString("specialization");
        	    String email = resultSet.getString("email");
        	    String phone = resultSet.getString("phone");

        	    Doctor doctor = new Doctor(name, specialization, email, phone);
        	

        	    doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    private Connection getDBConnection() throws SQLException {
        // Replace these with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/doctor_management";
        String username = "root";
        String password = "passwd";

        return DriverManager.getConnection(url, username, password);
    }
}
