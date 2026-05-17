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
     * Authenticates a user using email and password.
     * 
     * @param email user email
     * @param password user password
     * @return User object if login is successful, null otherwise
     */
    public User loginUser(String email, String password) {
        try {
            final String LOGIN_SQL = "SELECT * FROM users WHERE email=? AND password=?;";
            PreparedStatement ps = conn.prepareStatement(LOGIN_SQL);
            ps.setString(1, email);
            ps.setString(2, password);
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
}
