package Utilities;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

/**
 * Utility class for managing cookies in the web application.
 * 
 * This class provides helper methods to add, retrieve, and delete
 * cookies. It simplifies common cookie operations used for session
 * handling and user preferences.
 */
public class CookieUtil {

    /**
     * Adds a cookie to the response.
     * 
     * The cookie will be available for the entire application
     * and will expire after the specified time.
     * 
     * @param response HttpServletResponse used to add the cookie
     * @param name name of the cookie
     * @param value value of the cookie
     * @param maxAge maximum age of the cookie in seconds
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/"); // make cookie available across application
        response.addCookie(cookie);
    }

    /**
     * Retrieves a cookie by its name from the request.
     * 
     * This method searches all cookies in the request and returns
     * the first cookie matching the specified name.
     * 
     * @param request HttpServletRequest containing cookies
     * @param name name of the cookie to retrieve
     * @return Cookie object if found, otherwise null
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> name.equals(cookie.getName()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Deletes a cookie by setting its value to null
     * and max age to zero.
     * 
     * This effectively removes the cookie from the browser.
     * 
     * @param response HttpServletResponse used to send delete instruction
     * @param name name of the cookie to delete
     */
    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/"); // ensure same path as original cookie
        response.addCookie(cookie);
    }
}