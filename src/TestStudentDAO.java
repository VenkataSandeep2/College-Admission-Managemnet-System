import dao.StudentDAO;
import model.Student;
import java.util.List;

public class TestStudentDAO {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Test adding a new student
        Student s = new Student();
        s.setName("Test Student");
        s.setEmail("test@example.com");
        s.setMarks(85.5f);
        s.setCoursePreference("Computer Science");
        s.setStatus("pending");

        boolean added = dao.addStudent(s);
        System.out.println("✅ Student added: " + added);

        // Test getting all students
        List<Student> students = dao.getAllStudents();
        System.out.println("✅ Total students: " + students.size());

        // Test getting student by email
        Student fetched = dao.getStudentByEmail("test@example.com");
        if (fetched != null) {
            System.out.println("✅ Fetched student: " + fetched.getName());
        } else {
            System.out.println("❌ Student not found");
        }

        // Test updating status
        if (fetched != null) {
            boolean updated = dao.updateStatus(fetched.getId(), "approved");
            System.out.println("✅ Status updated: " + updated);
        }

        // Test deleting student
        if (fetched != null) {
            boolean deleted = dao.deleteStudent(fetched.getId());
            System.out.println("✅ Student deleted: " + deleted);
        }
    }
}
