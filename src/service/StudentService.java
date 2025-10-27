package service;

import dao.StudentDAO;
import java.util.Scanner;
import model.Student;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();
    private Scanner sc = new Scanner(System.in);

    public void studentMenu() {
    while (true) {
        System.out.println("\n===== Student Menu =====");
        System.out.println("1. Apply for Admission");
        System.out.println("2. Check Admission Status");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1 -> applyForAdmission();
            case 2 -> checkStatus();
            case 3 -> {
                System.out.println("Returning to main menu...");
                return;
            }
            default -> System.out.println("Invalid choice! Try again.");
        }
    }
}

    private void applyForAdmission() {
        sc.nextLine(); // consume newline
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your marks: ");
        float marks = sc.nextFloat();
        sc.nextLine();
        System.out.print("Enter course preference: ");
        String course = sc.nextLine();

        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setMarks(marks);
        s.setCoursePreference(course);
        s.setStatus("Pending");

        boolean added = studentDAO.addStudent(s);
        System.out.println(added ? "✅ Application submitted successfully!" : "❌ Application failed!");
    }

    private void checkStatus() {
        sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        Student s = studentDAO.getStudentByEmail(email);
        if (s != null) {
            System.out.println("Name: " + s.getName());
            System.out.println("Email: " + s.getEmail());
            System.out.println("Marks: " + s.getMarks());
            System.out.println("Course Preference: " + s.getCoursePreference());
            System.out.println("Status: " + s.getStatus());
        } else {
            System.out.println("❌ No record found for this email!");
        }
    }
}
