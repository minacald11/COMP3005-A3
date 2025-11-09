import java.util.List;
import java.util.Scanner;



/** Main Class 
 * 
 * This makes a menu that will appear when the program is launched. 
 * it lets the user do all the following requirments:
 *  1. View all students
 *   2. Add a new student
 *   3. Update a student's email
 *   4. Delete a student
 *   5. Exit the program
 * 
 * The program uses StudentDAO to interact with the database
 * 
 * 
*/


public class Main {
    public static void main(String[] args) {

        //scans the user input from the terminal (console)
        Scanner scanner = new Scanner(System.in);
        //then using our data access object (DAO) for interacting with the students database 
        StudentDAO dao = new StudentDAO();

        //We make a loop for the menu so it appears over and over after an operation has been chosen until the user chooses to exit the program.
        while (true) {

            //display these menu options onto the console
            System.out.println("\n=== STUDENT DATABASE MENU ===");
            System.out.println("1. Show all students");
            System.out.println("2. Add a student");
            System.out.println("3. Update a student's email");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            //read the user input(choice) as an INTEGER
            int choice = scanner.nextInt();

            scanner.nextLine(); // clear leftover newline to prevent input issues

            //Now we handle the users input(their choice)
            switch (choice) {

                // Show all students
                case 1:
                    System.out.println("\n--- All Students ---");
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                // Add a new student 
                case 2:
                    System.out.println("\n--- Add Student ---");
                    System.out.print("First name: ");
                    String first = scanner.nextLine();
                    System.out.print("Last name: ");
                    String last = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enrollment date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    dao.addStudent(first, last, email, date);
                    break;
                // Update Student's Email
                case 3:
                    System.out.println("\n--- Update Student Email ---");
                    System.out.print("Student ID: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New email: ");
                    String newEmail = scanner.nextLine();

                    dao.updateStudentEmail(idUpdate, newEmail);
                    break;
                // delete a student 
                case 4:
                    System.out.println("\n--- Delete Student ---");
                    System.out.print("Student ID: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();

                    dao.deleteStudent(idDelete);
                    break;
                // exit the program
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    //Invalid menu choice
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
