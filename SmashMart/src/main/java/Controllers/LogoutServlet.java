package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  1. Get session
        HttpSession session = request.getSession(false);

        //  2. Invalidate session (DESTROY it)
        if (session != null) {
            session.invalidate();
        }

        //  3. Redirect to login or home
        response.sendRedirect(request.getContextPath() + "/login");
    }
}