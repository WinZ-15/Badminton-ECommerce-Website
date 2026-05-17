package Model;

import java.sql.Timestamp;

/**
 * Represents a User in the system.
 * 
 * This class stores user-related information such as name,
 * email, password, role, address, phone number, and timestamps.
 * It is used to transfer user data between different layers
 * of the application (e.g., DAO, Servlets, JSP).
 */
public class User {

    /** Unique identifier for the user */
    private Integer userID;

    /** Full name of the user */
    private String name;

    /** Email address of the user */
    private String email;

    /** Encrypted password of the user */
    private String password;

    /** Role of the user (e.g., Admin, Buyer) */
    private String role;

    /** Address of the user */
    private String address;

    /** Contact phone number of the user */
    private String phone;

    /** Timestamp when the user was created */
    private Timestamp createdAt;

    /** Timestamp when the user was last updated */
    private Timestamp updatedAt;

    /**
     * Default constructor for User.
     */
    public User() {}

    /**
     * Gets the user ID.
     * 
     * @return user ID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the user ID.
     * 
     * @param userID unique identifier of user
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Gets the user's name.
     * 
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     * 
     * @param name full name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address.
     * 
     * @return email of user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * 
     * @param email email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password.
     * 
     * @return encrypted password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password encrypted password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user role.
     * 
     * @return role of user
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the user role.
     * 
     * @param role role of user (e.g., Admin, Buyer)
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the user's address.
     * 
     * @return address of user
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the user's address.
     * 
     * @param address address of user
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number.
     * 
     * @return phone number of user
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number.
     * 
     * @param phone contact number of user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the creation timestamp.
     * 
     * @return createdAt timestamp
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     * 
     * @param createdAt timestamp of creation
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last updated timestamp.
     * 
     * @return updatedAt timestamp
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated timestamp.
     * 
     * @param updatedAt timestamp of last update
     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}