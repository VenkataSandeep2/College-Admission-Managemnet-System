package service;

import dao.StudentDAO;
import java.util.List;
import java.util.Scanner;
import model.Student;

public class AdminService {
    private StudentDAO studentDAO = new StudentDAO();
    private Scanner sc = new Scanner(System.in);

    public void adminMenu() {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. View All Students");
            System.out.println("2. Approve/Reject Admission");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            if (sc.hasNextInt()) {
                int ch = sc.nextInt();
                switch (ch) {
                    case 1 -> listStudents();
                    case 2 -> updateAdmissionStatus();
                    case 3 -> deleteStudent();
                    case 4 -> {
                        System.out.println("Approved");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // consume invalid input
            }
        }
    }

    private void listStudents() {
        List<Student> list = studentDAO.getAllStudents();
        if (list.isEmpty()) System.out.println("No records found!");
        else list.forEach(Student::displayDetails);
    }

    private void updateAdmissionStatus() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new status (Approved/Rejected): ");
        String status = sc.nextLine();
        boolean updated = studentDAO.updateStatus(id, status);
        if (updated) {
            System.out.println("✅ Status updated successfully!");
            if ("Rejected".equalsIgnoreCase(status)) {
                // Automatically delete rejected student
                boolean deleted = studentDAO.deleteStudent(id);
                if (deleted) {
                    System.out.println("❌ Student record deleted due to rejection.");
                } else {
                    System.out.println("⚠️ Status updated but failed to delete record.");
                }
            }
        } else {
            System.out.println("❌ Update failed!");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        boolean deleted = studentDAO.deleteStudent(id);
        System.out.println(deleted ? "✅ Student deleted successfully!" : "❌ Delete failed!");
    }
}
