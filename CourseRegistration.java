
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistration {
    public static void main(String[] args) {
        List<String> courseList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Course Registration System!");
        System.out.println("======================================");
        
        boolean isRegistrationOpen = true;
        
        while (isRegistrationOpen) {
            System.out.println("\nMenu:");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    viewAvailableCourses(courseList);
                    break;
                case 2:
                    registerCourse(courseList, scanner);
                    break;
                case 3:
                    dropCourse(courseList, scanner);
                    break;
                case 4:
                    isRegistrationOpen = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                    break;
            }
        }
        
        System.out.println("\nThank you for using the Course Registration System!");
        
        scanner.close();
    }
    
    public static void viewAvailableCourses(List<String> courseList) {
        System.out.println("\nAvailable Courses:");
        
        if (courseList.isEmpty()) {
            System.out.println("No courses available at the moment.");
        } else {
            for (String course : courseList) {
                System.out.println(course);
            }
        }
    }
    
    public static void registerCourse(List<String> courseList, Scanner scanner) {
        System.out.print("\nEnter the course name: ");
        String courseName = scanner.nextLine();
        
        if (courseList.contains(courseName)) {
            System.out.println("You are already registered for this course.");
        } else {
            courseList.add(courseName);
            System.out.println("Successfully registered for the course: " + courseName);
        }
    }
    
    public static void dropCourse(List<String> courseList, Scanner scanner) {
        System.out.print("\nEnter the course name: ");
        String courseName = scanner.nextLine();
        
        if (courseList.contains(courseName)) {
            courseList.remove(courseName);
            System.out.println("Successfully dropped the course: " + courseName);
        } else {
            System.out.println("You are not registered for this course.");
        }
    }
}
