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
        // Load the SQLite JDBC driver (JDBC class implements java.sql.Driver)
        try {
            // Registering driver method
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Create a DB connection
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:contactmgr.db")) {
            System.out.println("Connection established");
            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Create a DB table
            statement.executeUpdate("DROP TABLE IF EXISTS contacts");
            statement.executeUpdate("CREATE TABLE contacts (id INTEGER PRIMARY KEY, firstname STRING, lastname STRING, email STRING, phone INT(10))");

            // Insert a couple contacts
            Contact c = new Contact("Chris", "Rama", "rama@mail.com", 1234567890L);
            save(c, statement);
            c = new Contact("James", "Blinq", "blinq@mail.com", 1234567890L);
            save(c, statement);

            // Fetch all the records from the contacts table
            ResultSet rs = statement.executeQuery("SELECT * FROM contacts");

            // Iterate over the ResultSet & display contact info
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

    public static void save(Contact contact, Statement statement) throws SQLException {
        // Compose query
        String sql = "INSERT INTO contacts (firstname, lastname, email, phone) VALUES ('%s','%s','%s',%d)";
        sql = String.format(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
        // Execute query
        statement.executeUpdate(sql);
    }
}