package model;

public class Admin extends Person {
    private String username;
    private String password;

    // Constructor
    public Admin(int id, String name, String email, String username, String password) {
        super(id, name, email);
        this.username = username;
        this.password = password;
    }

    // Default constructor
    public Admin() {}

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void displayDetails() {
        System.out.println("---- Admin Details ----");
        System.out.println("Admin ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("-----------------------");
    }
}
