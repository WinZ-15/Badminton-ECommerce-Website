package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for configuring and managing database connections.
 * 
 * This class provides a method to establish a connection
 * to the MySQL database using JDBC. It centralizes database
 * connection settings such as URL, username, and password.
 */
public class DBConfig {

    /** Database name */
    private static final String DB_NAME = "smashmart";

    /** Database username */
    private static final String USER = "root";

    /** Database password */
    private static final String PASSWORD = "";

    /** Database connection URL */
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

    /**
     * Establishes and returns a database connection.
     * 
     * This method loads the MySQL JDBC driver and creates
     * a connection using the configured URL, username, and password.
     * 
     * @return Connection object for interacting with the database
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if JDBC driver is not found
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}