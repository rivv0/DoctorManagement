package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Patient;
import utils.DBConnection;

public class PatientDAO {
    
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (username, password, full_name, email, phone) VALUES (?, ?, ?, ?, ?)"; // Remove patient_id from the query
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            // Set parameters without patientId since it is AUTO_INCREMENT
            preparedStatement.setString(1, patient.getUsername());
            preparedStatement.setString(2, patient.getPassword());
            preparedStatement.setString(3, patient.getFullName());
            preparedStatement.setString(4, patient.getEmail());
            preparedStatement.setString(5, patient.getPhone());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
