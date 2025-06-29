import java.util.*;

class Course {
    String code, title;
    int capacity;

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
    }

    public void display() {
        System.out.println(code + " - " + title + " | Seats Left: " + capacity);
    }
}

public class CourseRegistrationSystem {
    static Map<String, Course> courseList = new HashMap<>();
    static Map<String, List<String>> studentCourses = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize sample courses
        courseList.put("CS101", new Course("CS101", "Java Programming", 2));
        courseList.put("CS102", new Course("CS102", "Data Structures", 2));

        while (true) {
            System.out.println("\n--- Course Registration System ---");
            System.out.println("1. View Courses\n2. Register Course\n3. Drop Course\n4. View My Courses\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 5) break;

            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();
            studentCourses.putIfAbsent(studentId, new ArrayList<>());

            switch (choice) {
                case 1:
                    for (Course c : courseList.values()) c.display();
                    break;
                case 2:
                    System.out.print("Enter Course Code: ");
                    String regCode = sc.nextLine();
                    Course courseToRegister = courseList.get(regCode);
                    if (courseToRegister != null && courseToRegister.capacity > 0) {
                        if (!studentCourses.get(studentId).contains(regCode)) {
                            studentCourses.get(studentId).add(regCode);
                            courseToRegister.capacity--;
                            System.out.println("✅ Registered for " + regCode);
                        } else {
                            System.out.println("❗Already registered.");
                        }
                    } else {
                        System.out.println("❌ Course not available or full.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Course Code to Drop: ");
                    String dropCode = sc.nextLine();
                    if (studentCourses.get(studentId).remove(dropCode)) {
                        courseList.get(dropCode).capacity++;
                        System.out.println("✅ Dropped " + dropCode);
                    } else {
                        System.out.println("❌ Not registered in this course.");
                    }
                    break;
                case 4:
                    System.out.println("Your Courses: " + studentCourses.get(studentId));
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
