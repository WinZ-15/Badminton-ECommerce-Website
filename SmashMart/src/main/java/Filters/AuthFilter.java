package Filters;

import Dao.UserDAO;
import Model.User;
import Utilities.CookieUtil;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Central authentication and authorization filter.
 *
 * This filter handles: ✅ Cookie-based login authentication ✅ Role-based
 * authorization (admin vs buyer)
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        //  Allow static resources
        if (uri.endsWith(".css") || uri.endsWith(".js")
                || uri.endsWith(".png") || uri.endsWith(".jpg")
                || uri.contains("Resources")) {

            chain.doFilter(request, response);
            return;
        }

        //  Allow public pages
        if (uri.endsWith("/home")
                || uri.endsWith("/about.html")
                || uri.endsWith("/contact.html")
                || uri.endsWith(LOGIN)
                || uri.endsWith(REGISTER)) {

            chain.doFilter(request, response);
            return;
        }

//  SESSION + COOKIE AUTHENTICATION
        HttpSession session = req.getSession(false);
        User user = null;

        //  1. Check session
        if (session != null) {
            user = (User) session.getAttribute("user");
        }

        //  If no session → check cookie
        if (user == null) {
            Cookie cookie = CookieUtil.getCookie(req, "userEmail");

            if (cookie != null) {
                UserDAO dao = new UserDAO();
                user = dao.getUserByEmail(cookie.getValue());

                //  restore session
                if (user != null) {
                    req.getSession().setAttribute("user", user);
                }
            }
        }

        //   If still not found → redirect
        if (user == null) {
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Make user available to JSP
        req.setAttribute("user", user);

        //  Block buyer from admin pages
        if (uri.contains("adminDashboard")
                && !user.getRole().equalsIgnoreCase("admin")) {

            res.sendRedirect(req.getContextPath() + "/buyerDashboard");
            return;
        }

        //  Prevent logged-in user from going back to login/register
        if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
            res.sendRedirect(req.getContextPath() + "/buyerDashboard");
            return;
        }

        //  Allow access
        chain.doFilter(request, response);
    }
}
