package Controllers;

import Dao.AnalyticsDAO;
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

        // ✅ Create DAO
        AnalyticsDAO dao = new AnalyticsDAO();

        // ✅ SALES
        double weeklySales = dao.getSalesThisWeek();
        double totalRevenue = dao.getTotalSales();

        // ✅ COUNTS
        int totalUsers = dao.getTotalUsers();
        int totalProducts = dao.getTotalProducts();
        int totalOrders = dao.getTotalOrders();

        // ✅ RECENT ORDERS (simple display)
        ArrayList<String> recentOrders = dao.getRecentOrders();

        // ✅ SET ATTRIBUTES
        request.setAttribute("weeklySales", weeklySales);
        request.setAttribute("totalRevenue", totalRevenue);

        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalOrders", totalOrders);

        request.setAttribute("recentOrders", recentOrders);

        // ✅ FORWARD TO JSP
        request.getRequestDispatcher("Pages/analytics.jsp").forward(request, response);
    }
}