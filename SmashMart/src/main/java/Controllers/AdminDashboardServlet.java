package Controllers;

import Dao.CategoryDAO;
import Dao.ProductDAO;
import Dao.UserDAO;
import Dao.AnalyticsDAO;
import Dao.OrderDAO;

import Model.Category;
import Model.Order;
import Model.Product;
import Model.User;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "AdminDashboardServlet", urlPatterns = {"/adminDashboard"})
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            //  GET USER FROM SESSION
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            //  ROLE CHECK 
           if (user == null || !user.getRole().equalsIgnoreCase("admin")) {
                response.sendRedirect("home");
                return; 
            }

        try {
            //  LOAD ALL DATA
            CategoryDAO cdao = new CategoryDAO();
            ProductDAO pdao = new ProductDAO();
            UserDAO udao = new UserDAO();
            AnalyticsDAO adao = new AnalyticsDAO();
            OrderDAO odao = new OrderDAO();

            //  GET DATA FROM DB
            ArrayList<Category> categories = cdao.getAllCategories();
            ArrayList<Product> products = pdao.getAllProducts(); 
            ArrayList<User> users = udao.getAllUsers();      
            ArrayList<Order> orders = odao.getAllOrders();

            //  ANALYTICS
            int totalUsers = adao.getTotalUsers();
            int totalProducts = adao.getTotalProducts();
            int totalOrders = adao.getTotalOrders();
            double totalRevenue = adao.getTotalSales();


            //  SET ATTRIBUTES
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
            request.setAttribute("users", users); 
            request.setAttribute("orders",orders);

            request.setAttribute("totalUsers", totalUsers);
            request.setAttribute("totalProducts", totalProducts);
            request.setAttribute("totalOrders", totalOrders);
            request.setAttribute("totalRevenue", totalRevenue);

            //  FORWARD TO CORRECT PAGE
            RequestDispatcher rd = request.getRequestDispatcher("Pages/adminDashboard.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            throw new ServletException("Error loading dashboard data", ex);
        }
    }
}
