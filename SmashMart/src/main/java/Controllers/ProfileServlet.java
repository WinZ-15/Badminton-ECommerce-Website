package Controllers;

import Model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        //  Check login     
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute("user");
        }
        
        if (user == null) {
            response.sendRedirect("login");
            return;
        }

        // Send user to JSP
        request.setAttribute("user", user);
        request.getRequestDispatcher("Pages/profile.jsp")
               .forward(request, response);
    }
}