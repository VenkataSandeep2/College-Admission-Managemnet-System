# College-Admission-Managemnet-System

A Personal Java Project

Prepared by :- Adapala Venkata Sandeep

October 2025
 
1. Abstract

The College Admission Management System is a console-based Java application designed to automate the student admission workflow. The system enables students to apply for admission, check application status, and allows an administrator to review, approve, or reject applications. The project demonstrates object-oriented principles (inheritance, abstraction, encapsulation, polymorphism), JDBC connectivity to MySQL, and typical CRUD operations. This report documents the design, implementation, database schema, sample outputs, and future enhancements.

2. Objective
The primary objective of this project is to create a simple, maintainable, and functional admission management application that demonstrates Java OOP concepts and practical database integration. The system aims to reduce manual paperwork for admission processing and provide a clear, auditable flow for student registrations and admin approvals.
3. Technologies & Tools
Programming Language: Java (JDK 11/17+)
Database: MySQL 8+
Database Driver: MySQL Connector/J (JAR)
Connectivity: JDBC
IDE / Editor: Visual Studio Code / IntelliJ / Eclipse
OS: Windows (commands shown in report reflect Windows usage)
5. Project Modules
1. Student Module - Register a new student application, View application status by email.
2. Admin Module - View all student applications, Approve or reject applications, Delete student records.
3. Course Module - Stores course names and cutoff marks.
4. Admission Module - Links student to course and maintains admission status.
5. Database Connectivity Module - DatabaseConnection utility handles JDBC connections.
5. System Design - Class Diagram (text summary)
Person (abstract): id, name, email
Student extends Person: marks, coursePreference, status
Admin extends Person: username, password
Course: courseId, courseName, cutoffMarks
DAO Package: DatabaseConnection, StudentDAO, CourseDAO, AdminDAO, AdmissionDAO
Service Package: StudentService, AdminService
Main: program entry, presents main menu
6. Database Schema (SQL)
-- Database: college_admission_db
CREATE DATABASE IF NOT EXISTS college_admission_db;
USE college_admission_db;
CREATE TABLE students (...);
CREATE TABLE courses (...);
CREATE TABLE admissions (...);
CREATE TABLE admin (...);
INSERT INTO admin (username, password) VALUES ('admin', 'admin123');
7. Important Source Code Snippets
DatabaseConnection.java, StudentDAO.java methods for CRUD, AdminDAO.java methods, AdmissionDAO.java linking logic.
8. Execution / Run Instructions
1. Ensure MySQL is running.
2. Run SQL script.
3. Compile Java files with MySQL connector.
4. Run Main class.
5. Use interactive console to register students and manage admissions.
9. Sample Console Output
    
===== College Admission Management System =====
1. Student Portal
2. Admin Portal
3. Exit
Enter your choice: 1
...Student registered successfully!
10. Testing & Results
The system was tested by inserting multiple student records, validating unique email constraints, updating admission status, and ensuring database CRUD worked properly.
11. Conclusion
The College Admission Management System demonstrates modular architecture, Java OOP, DAO pattern, and JDBC database integration. Future improvements such as GUI and authentication can make it production-ready.
12. Acknowledgment
I, Adapala Venkata Sandeep, would like to thank my peers and online resources that helped me build this project. This exercise enhanced my understanding of Java programming and database integration.
13. Future Enhancements
- Add login authentication (hashed passwords)
- Build GUI using JavaFX or web interface
- Add automated merit-based seat allocation
- Send email notifications
- Add logging and unit tests
14. Appendix
File list:
model/*.java
dao/*.java
service/*.java
Main.java
database/college_admission.sql
lib/mysql-connector-j-9.0.0.jar
