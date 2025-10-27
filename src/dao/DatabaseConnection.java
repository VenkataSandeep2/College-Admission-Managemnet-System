package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // ✅ Update credentials based on your MySQL setup
    private static final String DB_URL = "jdbc:mysql://localhost:3306/college_admission_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root"; // your MySQL username
    private static final String DB_PASSWORD = "Sanjay@515"; // your MySQL password

    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver (needed if running manually)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found. Add connector JAR to classpath.", e);
        }

        // Establish and return connection
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
