package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Course;

public class CourseDAO {
    private Connection conn;

    public CourseDAO() throws SQLException {
        // Get database connection from DatabaseConnection.java
        conn = DatabaseConnection.getConnection();
    }

    // Add a new course
    public boolean addCourse(Course course) {
        String sql = "INSERT INTO courses (course_name, duration, fees) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getName());
            ps.setString(2, course.getDuration());
            ps.setDouble(3, course.getFees());
            return ps.executeUpdate() > 0;  // Returns true if insert was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all courses
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("course_id"));
                c.setName(rs.getString("course_name"));
                c.setDuration(rs.getString("duration"));
                c.setFees(rs.getDouble("fees"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update course
    public boolean updateCourse(Course course) {
        String sql = "UPDATE courses SET course_name=?, duration=?, fees=? WHERE course_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getName());
            ps.setString(2, course.getDuration());
            ps.setDouble(3, course.getFees());
            ps.setInt(4, course.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete course
    public boolean deleteCourse(int id) {
        String sql = "DELETE FROM courses WHERE course_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get course by ID
    public Course getCourseById(int id) {
        String sql = "SELECT * FROM courses WHERE course_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("course_id"));
                c.setName(rs.getString("course_name"));
                c.setDuration(rs.getString("duration"));
                c.setFees(rs.getDouble("fees"));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // if not found
    }
}
