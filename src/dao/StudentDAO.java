package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ✅ Add new student
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students (name, email, marks, course_preference, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setFloat(3, s.getMarks());
            pst.setString(4, s.getCoursePreference());
            pst.setString(5, s.getStatus());

            int rows = pst.executeUpdate();

            // Get generated student ID
            if (rows > 0) {
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        s.setId(rs.getInt(1));
                    }
                }
            }
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error adding student: " + e.getMessage());
            return false;
        }
    }

    // ✅ Get student by email
    public Student getStudentByEmail(String email) {
        String sql = "SELECT * FROM students WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setMarks(rs.getFloat("marks"));
                s.setCoursePreference(rs.getString("course_preference"));
                s.setStatus(rs.getString("status"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching student: " + e.getMessage());
        }
        return null;
    }

    // ✅ List all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setMarks(rs.getFloat("marks"));
                s.setCoursePreference(rs.getString("course_preference"));
                s.setStatus(rs.getString("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error listing students: " + e.getMessage());
        }
        return list;
    }

    // ✅ Update status (approved/rejected)
    public boolean updateStatus(int studentId, String newStatus) {
        String sql = "UPDATE students SET status = ? WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, newStatus);
            pst.setInt(2, studentId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error updating status: " + e.getMessage());
            return false;
        }
    }

    // ✅ Delete student
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error deleting student: " + e.getMessage());
            return false;
        }
    }
}
