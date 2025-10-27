package model;

public class Student extends Person {
    private float marks;
    private String coursePreference;
    private String status;

    // Constructor
    public Student(int id, String name, String email, float marks, String coursePreference, String status) {
        super(id, name, email); // Calling Person constructor
        this.marks = marks;
        this.coursePreference = coursePreference;
        this.status = status;
    }

    // Default Constructor
    public Student() {}

    // Getters and Setters
    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getCoursePreference() {
        return coursePreference;
    }

    public void setCoursePreference(String coursePreference) {
        this.coursePreference = coursePreference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Implementation of abstract method
    @Override
    public void displayDetails() {
        System.out.println("---- Student Details ----");
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Marks: " + marks);
        System.out.println("Course Preference: " + coursePreference);
        System.out.println("Status: " + status);
        System.out.println("--------------------------");
    }
}
