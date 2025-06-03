package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Replace "yourdbname" with your actual database name.
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/databaseexport?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "brandon123";  // An empty string if you're using the default setup

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loads the MySQL JDBC driver
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
        return conn;
    }
    
    // Optional test method if you want to verify the connection quickly.
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Failed to connect.");
        }
    }
}
