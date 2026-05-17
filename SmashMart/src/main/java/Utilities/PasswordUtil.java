package Utilities;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class for handling password security operations.
 * 
 * This class provides methods to hash passwords and verify
 * user-entered passwords using BCrypt. It ensures secure
 * password storage and authentication.
 */
public class PasswordUtil {

    /**
     * Cost factor for BCrypt hashing.
     * Higher values increase security but also computation time.
     */
    private final static int COST = 10;

    /**
     * Generates a hashed version of the given password.
     * 
     * This method uses BCrypt to create a salted hash of the password,
     * making it secure against brute-force and rainbow table attacks.
     * 
     * @param inputPassword plain text password entered by user
     * @return hashed password string
     */
    public static String getHashPassword(String inputPassword) {
        // Generate salt and hash password
        String salt = BCrypt.gensalt(COST);
        return BCrypt.hashpw(inputPassword, salt);
    }

    /**
     * Verifies a password against its hashed version.
     * 
     * This method compares the plain text password entered by
     * the user with the hashed password stored in the database.
     * 
     * @param passwordTyped password entered by the user
     * @param hashedPassword stored hashed password
     * @return true if passwords match, false otherwise
     */
    public static boolean checkPassword(String passwordTyped, String hashedPassword) {
        return BCrypt.checkpw(passwordTyped, hashedPassword);
    }
}