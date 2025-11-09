
/**
 * Student class
 * -------------
 * Represents a student record in the database.
 * Each student has an ID, first name, last name, email, and enrollment date.
 */


public class Student {

    //their identifier, the number on the left beside their name
    private int id;
    //first name, last name, email, enrollmentDate(YYYY-MM-DD)
    private String firstName;
    private String lastName;
    private String email;
    private String enrollmentDate;

    //Constructor, initializing the student object
    public Student(int id, String firstName, String lastName, String email, String enrollmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    //this will return a string of the student. 
    @Override
    public String toString() {
        return id + " | " + firstName + " | " + lastName + " | " + email + " | " + enrollmentDate;
    }
}
