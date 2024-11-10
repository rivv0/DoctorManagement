package dao;

import models.Doctor;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    public static List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctors");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Doctor doctor = new Doctor(null, null, null, null);
                doctor.setDoctorId(resultSet.getInt("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setSpecialization(resultSet.getString("specialization"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setPhone(resultSet.getString("phone"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    public void addDoctor(Doctor newDoctor) {
        String sql = "INSERT INTO doctors (name, specialization, email, phone) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newDoctor.getName());
            statement.setString(2, newDoctor.getSpecialization());
            statement.setString(3, newDoctor.getEmail());
            statement.setString(4, newDoctor.getPhone());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add other CRUD methods for Doctor as needed
}