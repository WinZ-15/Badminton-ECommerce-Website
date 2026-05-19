package Controllers;

import Dao.UserDAO;
import Model.User;
import Utilities.PasswordUtil;
import Utilities.ValidationUtil;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("fullName").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String confirmPassword = request.getParameter("confirmPassword");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        // 1. Validate empty fields
        if (ValidationUtil.isNullOrEmpty(name)
                || ValidationUtil.isNullOrEmpty(email)
                || ValidationUtil.isNullOrEmpty(password)
                || ValidationUtil.isNullOrEmpty(confirmPassword)) {

            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

//  Name
        if (!ValidationUtil.isAlphanumericStartingWithLetter(name)) {
            request.setAttribute("error", "Name must start with a letter and contain only letters and numbers");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        //2. email
        if (!ValidationUtil.isValidEmail(email)) {
            request.setAttribute("error", "Invalid email format");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 3. Password 
        if (!ValidationUtil.isValidPassword(password)) {
            request.setAttribute("error", "Password must contain uppercase, number, special character and be at least 6 characters");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 4.  password Check
        if (!ValidationUtil.doPasswordsMatch(password, confirmPassword)) {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 5. Phone 
        if (!ValidationUtil.isNullOrEmpty(phone)
                && !ValidationUtil.isValidPhoneNumber(phone)) {

            request.setAttribute("error", "Invalid phone number format");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        UserDAO dao = new UserDAO();

        //  Check duplicate email
        if (dao.getUserByEmail(email) != null) {
            request.setAttribute("error", "Email already registered");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Hash password
        String hashedPassword = PasswordUtil.getHashPassword(password);

        // user creating
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRole("Buyer");
        user.setAddress(address);
        user.setPhone(phone);

        //  Save to DB
        boolean success = dao.registerUser(user);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute("error", "Registration failed");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

}
