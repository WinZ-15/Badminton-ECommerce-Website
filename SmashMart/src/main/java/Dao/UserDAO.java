package Dao;

import Model.User;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for managing User data.
 * 
 * This class contains methods for performing database operations
 * related to users such as registration, login, retrieval, and search.
 * It acts as a bridge between the application and the database.
 */
public class UserDAO {
    /** Database connection object */
    private Connection conn;

    /** Flag to indicate connection error */
    private boolean isConnectionError = false;

    /**
     * Constructor to initialize database connection.
     */
    public UserDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            isConnectionError = true;
            System.out.println(ex.getLocalizedMessage());
        }
    }

    /**
     * Registers a new user in the database.
     * 
     * @param user User object containing registration details
     * @return true if user was successfully registered, false otherwise
     */
    public boolean registerUser(User user) {
        try {
            final String INSERT_USER =
                "INSERT INTO users(name,email,password,role,address,phone) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(INSERT_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhone());
            int result = ps.executeUpdate();
            return (result > 0);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }

    /**
     * Retrieves all users from the database.
     * 
     * @return list of all users
     * @throws SQLException if database error occurs
     */
    public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        }
        return users;
    }

    /**
     * Retrieves a user by email.
     * 
     * @param email email to search for
     * @return User object if found, null otherwise
     */
    public User getUserByEmail(String email) {
        try {
            final String SQL = "SELECT * FROM users WHERE email=?;";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                return user;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }
    

/**
 * Updates an existing user's details in the database.
 * This method updates the user's name, address, phone, and password
 * based on the provided {@link User} object. The user is identified
 * by their email address, which is not modified.
 *
 * @param user the {@link User} object containing updated user information;
 *             must include a valid email to identify the record in the database
 * @throws SQLException if a database access error occurs or the SQL execution fails
 */

    public void updateUser(User user) throws SQLException {
    String sql = "UPDATE users SET name=?, address=?, phone=?, password=? WHERE email=?";

    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, user.getName());
    ps.setString(2, user.getAddress());
    ps.setString(3, user.getPhone());
    ps.setString(4, user.getPassword());
    ps.setString(5, user.getEmail());

    ps.executeUpdate();

}
}
