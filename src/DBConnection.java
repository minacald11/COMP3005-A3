import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection class
 * ------------------
 * Provides a method to establish a connection to the PostgreSQL database.
 * Other classes (like StudentDAO) can use this method to interact with the database.
 */

public class DBConnection {

    //this is the JDBC URL for connecting to PostgreSQL database
    //IMPORTANT: please replace "your_username_here" and "your_password_here" with your own username and password!!
    private static final String URL = "jdbc:postgresql://localhost:5433/calderon_MinaCOMP3005_A3";
    // private static final String USER = "your_username_here";
    // private static final String PASSWORD = "your_password_here";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Lps223341";

    //creates and returns connection object to the PostgreSQl database.
    public static Connection getConnection() {
        Connection conn = null;

        try {
            //Load the SQL JDBC driver class
            Class.forName("org.postgresql.Driver");
            //attempts to establish a connection to database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            //if it fails to find the SQL driver class or if database error happens,  it shows error message, returns null.
            System.out.println("Connection failed: " + e.getMessage());
        }



        return conn;
    }
}