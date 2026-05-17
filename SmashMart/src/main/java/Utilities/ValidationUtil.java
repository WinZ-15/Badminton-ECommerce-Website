package Utilities;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;
import jakarta.servlet.http.Part;

/**
 * Utility class for performing input validation.
 * 
 * This class provides various static methods to validate user inputs
 * such as email, phone number, password, and file uploads.
 * It helps enforce data integrity and prevent invalid data from being processed.
 */
public class ValidationUtil {

    /**
     * Checks if a string is null or empty.
     * 
     * @param value input string
     * @return true if null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Checks if a string contains only alphabetic characters.
     * 
     * @param value input string
     * @return true if only letters, false otherwise
     */
    public static boolean isAlphabetic(String value) {
        return value != null && value.matches("^[a-zA-Z]+$");
    }

    /**
     * Checks if a string starts with a letter and contains only
     * alphanumeric characters.
     * 
     * @param value input string
     * @return true if valid, false otherwise
     */
    public static boolean isAlphanumericStartingWithLetter(String value) {
        return value != null && value.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }

    /**
     * Validates gender value.
     * 
     * @param value input gender string
     * @return true if value is "male" or "female", false otherwise
     */
    public static boolean isValidGender(String value) {
        return value != null &&
               (value.equalsIgnoreCase("male") ||
                value.equalsIgnoreCase("female"));
    }

    /**
     * Validates if the input is a proper email address.
     * 
     * @param email email string
     * @return true if valid email format, false otherwise
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    /**
     * Validates Nepali phone number format.
     * 
     * The number must start with 98 and have 10 digits.
     * 
     * @param number phone number string
     * @return true if valid format, false otherwise
     */
    public static boolean isValidPhoneNumber(String number) {
        return number != null && number.matches("^98\\d{8}$");
    }

    /**
     * Validates password strength.
     * 
     * Password must contain:
     * - At least one uppercase letter
     * - At least one digit
     * - At least one special character
     * - Minimum length of 6 characters
     * 
     * @param password input password
     * @return true if strong password, false otherwise
     */
    public static boolean isValidPassword(String password) {
        String passwordRegex =
            "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$";
        return password != null && password.matches(passwordRegex);
    }

    /**
     * Validates image file extension.
     * 
     * Only allows files with extensions: jpg, jpeg, png, gif.
     * 
     * @param imagePart uploaded file part
     * @return true if image format is valid, false otherwise
     */
    public static boolean isValidImageExtension(Part imagePart) {
        if (imagePart == null || isNullOrEmpty(imagePart.getSubmittedFileName())) {
            return false;
        }

        String fileName = imagePart.getSubmittedFileName().toLowerCase();

        return fileName.endsWith(".jpg") ||
               fileName.endsWith(".jpeg") ||
               fileName.endsWith(".png") ||
               fileName.endsWith(".gif");
    }

    /**
     * Checks if two passwords match.
     * 
     * @param password original password
     * @param retypePassword confirmation password
     * @return true if both passwords match, false otherwise
     */
    public static boolean doPasswordsMatch(String password, String retypePassword) {
        return password != null && password.equals(retypePassword);
    }

    /**
     * Checks if a user is at least 16 years old.
     * 
     * @param dob date of birth
     * @return true if age is 16 or above, false otherwise
     */
    public static boolean isAgeAtLeast16(LocalDate dob) {
        if (dob == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears() >= 16;
    }
}