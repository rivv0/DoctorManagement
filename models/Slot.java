package models;

public class Slot {
    private int slotId; // This will be auto-generated by the database
    private int doctorId;
    private String slotDate;
    private String slotTime;
    private boolean isBooked;

    // Constructor for creating a new Slot
    public Slot(int doctorId, String slotDate, String slotTime) {
        this.doctorId = doctorId;
        this.slotDate = slotDate;
        this.slotTime = slotTime;
        this.isBooked = false; // Default value
    }

    // Getters
    public int getSlotId() { return slotId; }
    public int getDoctorId() { return doctorId; }
    public String getSlotDate() { return slotDate; }
    public String getSlotTime() { return slotTime; }
    public boolean isBooked() { return isBooked; }

    // Setters
    public void setSlotId(int slotId) { this.slotId = slotId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public void setSlotDate(String slotDate) { this.slotDate = slotDate; }
    public void setSlotTime(String slotTime) { this.slotTime = slotTime; }
    public void setBooked(boolean booked) { isBooked = booked; }
}

