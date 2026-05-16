package Controllers;

import Dao.AnalyticsDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AnalyticsServlet", urlPatterns = {"/analytics"})
public class AnalyticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession();
       Model.User user = (User) session.getAttribute("user");

       // ROLE CHECK
       if (user == null || !user.getRole().equalsIgnoreCase("admin")) {
           response.sendRedirect("home");
           return;
       }
        AnalyticsDAO dao = new AnalyticsDAO();

        //  SALES
        double weeklySales = dao.getSalesThisWeek();
        double totalRevenue = dao.getTotalSales();

        //  COUNT
        int totalUsers = dao.getTotalUsers();
        int totalProducts = dao.getTotalProducts();
        int totalOrders = dao.getTotalOrders();

        //  RECENT ORDER
        ArrayList<String> recentOrders = dao.getRecentOrders();

        // SET ATTRIBUTE
        request.setAttribute("weeklySales", weeklySales);
        request.setAttribute("totalRevenue", totalRevenue);

        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalOrders", totalOrders);

        request.setAttribute("recentOrders", recentOrders);

        //  FORWARD TO JSP
        request.getRequestDispatcher("Pages/analytics.jsp").forward(request, response);
    }
}