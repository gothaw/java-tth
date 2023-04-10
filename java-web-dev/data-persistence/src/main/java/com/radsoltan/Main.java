package com.radsoltan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TODO: Load the SQLite JDBC driver (JDBC class implements java.sql.Driver)
        try {
            // Registering driver method
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // TODO: Create a DB connection
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:contactmgr.db")) {
            System.out.println("Connection established");
            // TODO: Create a SQL statement
            Statement statement = connection.createStatement();

            // TODO: Create a DB table
            statement.executeUpdate("DROP TABLE IF EXISTS contacts");
            statement.executeUpdate("CREATE TABLE contacts (id INTEGER PRIMARY KEY, firstname STRING, lastname STRING, email STRING, phone INT(10))");

            // TODO: Insert a couple contacts
            statement.executeUpdate("INSERT INTO contacts (firstname, lastname, email, phone) VALUES('Chris', 'Rama', 'rama@mail.com', 1234567890)");
            statement.executeUpdate("INSERT INTO contacts (firstname, lastname, email, phone) VALUES('James', 'Blinq', 'blinq@mail.com', 1234567890)");

            // TODO: Fetch all the records from the contacts table
            ResultSet rs = statement.executeQuery("SELECT * FROM contacts");

            // TODO: Iterate over the ResultSet & display contact info
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");

                System.out.printf("%s %s (%d) \n", firstName, lastName, id);
            }

        } catch (SQLException ex) {
            // Display connection or query errors
            System.err.printf("There was a database error: %s%n",ex.getMessage());
        }
    }
}