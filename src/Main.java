import service.StudentService;
import service.AdminService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        AdminService adminService = new AdminService();

        while (true) {
            System.out.println("\n===== College Admission Management System =====");
            System.out.println("1. Student Portal");
            System.out.println("2. Admin Portal");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> studentService.studentMenu();
                case 2 -> adminService.adminMenu();
                case 3 -> {
                    System.out.println("Thank you for using the system!");
                    return;
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}
