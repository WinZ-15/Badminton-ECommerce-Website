package Controllers;

import Utilities.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CookieUtil.deleteCookie(response, "userEmail");
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        //  Redirect to login or home
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
