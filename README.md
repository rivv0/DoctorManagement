# DoctorManagement

## Overview

This is a Java-based project designed to connect doctors and patients. It enables users to manage doctors, view doctors, and appointments requests for doctors. The application utilizes Java for the user interface and MySQL for data storage, ensuring a seamless experience for both providers and collectors.

## Features

- **View Doctors**: Shows available doctors and their speciality along with doctor_id and phone number.
- **Manage Patinets**: To add patients they can fill the details to add on details .
- **Appointment Management**: Patients can book any doctos slot for the give date and time.
- **Manage Doctors**: Add doctos to the database.
- **Map Viewer**: Displays nearby hospitals for easy access and interaction.

## Technologies Used

- **Java**: The primary programming language for the application.
- **MySQL**: For database management.
- **JDBC**: For connecting to the MySQL database.

## Installation

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that JDK 11 or higher is installed on your system.
- **MySQL**: Install MySQL and create a database named `doctor_management`.
- **JavaFX SDK**: Download the JavaFX SDK and ensure it is correctly configured in your IDE.

### Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/rivv0/DoctorManagement.git
   cd DocotorManagement
   ```

2. **Database Configuration**:
   - Open MySQL and create the required tables using the provided SQL commands:
     ```sql
     CREATE DATABASE fdoctor_maangement;
     USE doctor_management;
     -- Create tables here (doctos, patients, slots, appointments)
     ```

3. **Configure Database Connection**:
   - Update the `DBConnection` class with your MySQL username, password, and database URL if necessary.


4. **Build and Run**:
   - Use your IDE (e.g., IntelliJ IDEA, Eclipse) to build and run the application.
   - Alternatively, compile and run using the command line.

