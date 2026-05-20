package Controllers;

import Dao.UserDAO;
import Model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "EditProfileServlet", urlPatterns = {"/editProfile"})
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        request.getRequestDispatcher("Pages/editProfile.jsp")
                .forward(request, response);
    }

    // HANDLE UPDATE (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        User user = (User) session.getAttribute("user");

        // Get updated values
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        // Validation
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("error", "Name cannot be empty");
            request.setAttribute("user", user);
            request.getRequestDispatcher("Pages/editProfile.jsp").forward(request, response);
            return;
        }

        // Update values
        user.setName(name.trim());
        user.setAddress(address.trim());


        if (password != null && !password.isEmpty()) {
            String hashedPassword = Utilities.PasswordUtil.getHashPassword(password);
            user.setPassword(hashedPassword);
        }

        // Update DB
        try {
            new UserDAO().updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("user", user);

        // Redirect back to profile
        response.sendRedirect("profile");
    }
}
