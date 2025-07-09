# Pasien (Patient Management System)

A comprehensive CRUD (Create, Read, Update, Delete) application for managing patient records using Spring Boot,
Thymeleaf, MySQL, and HikariCP.

## Overview

This application provides a web-based interface for managing patient (Pasien) records and their addresses (Alamat). It's
built with modern Java technologies and follows best practices for web application development.

## Features

- Complete CRUD operations for patient records
- Address management
- Responsive web interface using Bootstrap
- Data validation
- Flash messages for operation status

## Technologies Used

- **Backend**:
    - Java 21
    - Spring Boot 3.5.3
    - Spring Data JPA
    - HikariCP (Connection Pooling)
    - MySQL Database

- **Frontend**:
    - Thymeleaf
    - Bootstrap 5.3.7
    - jQuery 3.7.1
    - DataTables 2.3.0
    - AngularJS 1.8.3
    - Bootstrap Datepicker 1.10.0

- **Testing**:
    - JUnit
    - Spring Boot Test

## Prerequisites

- JDK 21
- Maven
- MySQL Server

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/Pasien.git
   cd Pasien
   ```

2. **Configure the database**:
    - Create a MySQL database named `pasien` (or update the configuration in `application.properties`)
    - Update the database username and password in `application.properties` if needed

3. **Build and run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application**:
   Open your browser and navigate to `http://localhost:8080/pasien`

## Project Structure

- `src/main/java/com/hendisantika/pasien/`: Java source files
    - `controller/`: MVC controllers
    - `domain/`: Entity classes
    - `repositories/`: Spring Data repositories
    - `service/`: Service layer implementations

- `src/main/resources/`: Configuration and static resources
    - `templates/`: Thymeleaf templates
    - `application.properties`: Application configuration

## Database Schema

The application uses two main entities:

1. **Pasien (Patient)**:
    - pasienId (UUID)
    - name
    - kelurahan (Village/Ward)
    - kecamatan (District)
    - kota (City)
    - telpon (Phone)
    - rtrw (RT/RW - Indonesian administrative divisions)
    - tanggalLahir (Date of Birth)
    - kelamin (Gender)

2. **Alamat (Address)**:
    - id (UUID)
    - kelurahan (Village/Ward)
    - kecamatan (District)
    - kota (City)

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Hendi Santika
