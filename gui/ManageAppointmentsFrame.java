package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.SlotDAO;
import models.Slot;

public class ManageAppointmentsFrame extends JFrame {
    
    public ManageAppointmentsFrame() {
        setTitle("Manage Appointments");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        JLabel lblDoctorId = new JLabel("Doctor ID:");
        lblDoctorId.setBounds(10, 20, 80, 25);
        add(lblDoctorId);
        
        JTextField txtDoctorId = new JTextField(20);
        txtDoctorId.setBounds(100, 20, 165, 25);
        add(txtDoctorId);
        
        JLabel lblSlotDate = new JLabel("Slot Date:");
        lblSlotDate.setBounds(10, 50, 80, 25);
        add(lblSlotDate);
        
        JTextField txtSlotDate = new JTextField(20);
        txtSlotDate.setBounds(100, 50, 165, 25);
        add(txtSlotDate);
        
        JLabel lblSlotTime = new JLabel("Slot Time:");
        lblSlotTime.setBounds(10, 80, 80, 25);
        add(lblSlotTime);
        
        JTextField txtSlotTime = new JTextField(20);
        txtSlotTime.setBounds(100, 80, 165, 25);
        add(txtSlotTime);
        
        JButton btnBookAppointment = new JButton("Book Appointment");
        btnBookAppointment.setBounds(10, 110, 150, 25);
        add(btnBookAppointment);
        
        btnBookAppointment.addActionListener(e -> {
            int doctorId = Integer.parseInt(txtDoctorId.getText());
            String slotDate = txtSlotDate.getText();
            String slotTime = txtSlotTime.getText();
            
            // Create Slot object without slotId since it's auto-incremented
            Slot newSlot = new Slot(doctorId, slotDate, slotTime); // Removed slotId
            SlotDAO slotDAO = new SlotDAO();
            slotDAO.addSlot(newSlot); // Method to save slot
            JOptionPane.showMessageDialog(null, "Appointment booked for Doctor ID: " + doctorId);
        });
        
        setVisible(true);
    }
}

