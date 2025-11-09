#Mina Calderon 101298433
COMP3005 Assignment 3


##Description
This Java project demonstrates database connectivity, SQL operations, and JDBC usage
through an application that connects to a PostgreSQL database to perform CRUD operations (Create, Read, Update, Delete) on a students table.

*- Download the PostgreSQL JDBC driver from https://jdbc.postgresql.org/download.html
 if you don’t already have it. Place the JAR in the project folder and include it in the classpath when compiling and running.*


##Structure

- db/ -> setup.sql , contains the student table and creates/populated the initial data. 
- src/ -> source files:
    - DBConnection.java # Handles database connection (JDBC)
    - Student.java # Student class (data model)
    - StudentDAO.java # Data Access Object with CRUD methods
    - Main.java # Main console program (menu)
    - postgresql-42.7.8.jar # PostgreSQL JDBC driver


##How to Compile and Run the program

Important: Update DBConnection.java with your own database username, password, and port before running the program.

Step 1: Create the database
    Open pgAdmin (or psql) and create a database named:
    CREATE DATABASE calderon_MinaCOMP3005_A3;
Step 2: Run the setup script
    Open the Query Tool for calderon_MinaCOMP3005_A3
    Execute the contents of setup.sql to create and populate the students table.

Step 3: Compile the Program (Replace postgresql-42.x.x.jar with the exact version of the JDBC driver if it’s different.)
    for windows: javac -cp ".;postgresql-42.x.x.jar" Main.java StudentDAO.java DBConnection.java Student.java
    for macOS/Linux:  javac -cp ".:postgresql-42.x.x.jar" Main.java StudentDAO.java DBConnection.java Student.java

Step 4: Run (Replace postgresql-42.x.x.jar with the exact version of the JDBC driver if it’s different.).
    Windows: java -cp ".;postgresql-42.x.x.jar" Main
    macOS/Linux: java -cp ".:postgresql-42.x.x.jar" Main

Video: 
link: https://youtu.be/PL2obfC3bFs
