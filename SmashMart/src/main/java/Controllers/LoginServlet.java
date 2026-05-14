package Controllers;

import Dao.UserDAO;
import Model.User;
import Utilities.CookieUtil;
import Utilities.PasswordUtil;
import Utilities.SessionUtil;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Please enter email and password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmail(email);

        if (user != null) {
            String hashedPassword = user.getPassword();
            boolean matched = PasswordUtil.checkPassword(password, hashedPassword);

            if (matched) {
                // we store user object in session with user attribute
                SessionUtil.setAttribute(request, "user", user);
                // in seconds sec*min*hr=total sec
                CookieUtil.addCookie(response, "name", user.getName(), 60 * 60 * 24);// 1 day
                CookieUtil.addCookie(response, "id", String.valueOf(user.getUserID()), 60 * 60 * 24);// 1 day
             
                // ROLE CHECK
              if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect(request.getContextPath() + "/adminDashboard");
                } else {
                    response.sendRedirect(request.getContextPath() + "/buyerDashboard");
                }

            } else {
                request.setAttribute("error", "Invalid email or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
