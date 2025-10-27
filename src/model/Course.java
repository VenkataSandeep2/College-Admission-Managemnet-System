package model;

public class Course {
    private int id;
    private String name;
    private String duration;
    private double fees;

    // Constructor
    public Course(int id, String name, String duration, double fees) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fees = fees;
    }

    // Default Constructor
    public Course() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    // Display method
    public void displayCourseDetails() {
        System.out.println("---- Course Details ----");
        System.out.println("Course ID: " + id);
        System.out.println("Course Name: " + name);
        System.out.println("Duration: " + duration);
        System.out.println("Fees: " + fees);
        System.out.println("------------------------");
    }
}
