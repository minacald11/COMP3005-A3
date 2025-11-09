import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO class
 * 
 * Data Access Object (DAO) for interacting with the "students" table in the database.
 * Provides methods to perform CRUD operations:
 *   - getAllStudents(): Retrieve all students
 *   - addStudent(): Add a new student
 *   - updateStudentEmail(): Update a student's email by ID
 *   - deleteStudent(): Delete a student by ID
 *
 * Uses DBConnection to get a database connection.
 */

public class StudentDAO {

    //Retrieves all the students from the database, given by student_id.
    public List<Student> getAllStudents() {

        //make an empty list to store students
        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM students ORDER BY student_id";

        //used to automatically close the connect, statement and resultSet.
        try (Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // create a student object from the current row in ResultSet
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("enrollment_date")
                );

                //and then we add the student  and its info into the list.
                students.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        //return the list of students avaialable 
        return students;
    }


    //adding a student into our database
    public void addStudent(String firstName, String lastName, String email, String enrollmentDate) {
        //this is the query that is beign used to add students. 
        String query = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        
        //we will connect our DBConnection and set the values for our prepared statment
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            //set these values in the correct order 
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setDate(4, java.sql.Date.valueOf(enrollmentDate)); // Converts String to java.sql.Date

            //insert it
            pstmt.executeUpdate(); 
            System.out.println("Student added.");

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    //updating a students email
    public void updateStudentEmail(int id, String newEmail) {
        String query = "UPDATE students SET email = ? WHERE student_id = ?";
        //same as the others, connect and then set the values for the statement.
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            //set new email
            pstmt.setString(1, newEmail);
            //specify which student by their ID
            pstmt.setInt(2, id);
            
            //execute the update 
            pstmt.executeUpdate();
            System.out.println("Email updated.");

        } catch (SQLException e) {
            System.out.println("Error updating email: " + e.getMessage());
        }
    }
    
    //deleting a student using their ID
    public void deleteStudent(int id) {
        //SQL Query 
        String query = "DELETE FROM students WHERE student_id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            //set the student ID into the placeholder query
            pstmt.setInt(1, id);
            
            //execute the deletion
            pstmt.executeUpdate();
            System.out.println("Student deleted.");

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
