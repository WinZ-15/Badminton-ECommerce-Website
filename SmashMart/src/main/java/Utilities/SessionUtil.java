package Utilities;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Utility class for managing HTTP session operations.
 * 
 * This class provides helper methods for setting, retrieving,
 * and removing session attributes, as well as invalidating sessions.
 * It helps simplify session management across the application.
 */
public class SessionUtil {

    /**
     * Sets an attribute in the session.
     * 
     * If a session does not already exist, a new session is created.
     * 
     * @param request HttpServletRequest used to access the session
     * @param key attribute name
     * @param value attribute value to store in session
     */
    public static void setAttribute(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    /**
     * Retrieves an attribute from the session.
     * 
     * This method returns null if the session does not exist
     * or if the attribute is not found.
     * 
     * @param request HttpServletRequest used to access the session
     * @param key attribute name to retrieve
     * @return attribute value or null if not found
     */
    public static Object getAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return session.getAttribute(key);
        }
        return null;
    }

    /**
     * Removes a specific attribute from the session.
     * 
     * If the session does not exist, no action is performed.
     * 
     * @param request HttpServletRequest used to access the session
     * @param key attribute name to remove
     */
    public static void removeAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(key);
        }
    }

    /**
     * Invalidates the current session.
     * 
     * This method logs out the user by destroying the session
     * and removing all stored attributes.
     * 
     * @param request HttpServletRequest used to access the session
     */
    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}