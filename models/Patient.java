package models;

public class Patient {
    private int patientId; // Use camelCase for member variables
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;

    // Constructor
    public Patient(String username, String password, String fullName, String email, String phone) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.patientId = 0; // Default value, as it's auto-incremented
    }

    // Getters
    public int getPatientId() { return patientId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    // Setters
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}
