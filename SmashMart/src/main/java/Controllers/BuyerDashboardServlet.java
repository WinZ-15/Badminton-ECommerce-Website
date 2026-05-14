package Controllers;

import Dao.CategoryDAO;
import Dao.ProductDAO;
import Model.Product;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "BuyerDashboardServlet", urlPatterns = {"/buyerDashboard"})
public class BuyerDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. LOADING PRODUCTS
            ProductDAO dao = new ProductDAO();
            String search = request.getParameter("search");
            String category = request.getParameter("category");

            ArrayList<Product> products;
            if (category != null && !category.isEmpty()) {
                products = dao.getProductsByCategory(Integer.parseInt(category));
            } 
            else if (search != null && !search.isEmpty()) {
                products = dao.searchProducts(search);
            }
            else {
                products = dao.getAllProducts();
            }

            CategoryDAO cdao = new CategoryDAO();
            request.setAttribute("categories", cdao.getAllCategories());

            //  2. CART COUNT Using SESSION
            HttpSession session = request.getSession(false);
            int cartCount = 0;
            if (session != null) {
                ArrayList<?> cart = (ArrayList<?>) session.getAttribute("cart");
                cartCount = (cart != null) ? cart.size() : 0;
            }

            // 3. SETTING ATTRIBUTES
            request.setAttribute("products", products);
            request.setAttribute("cartCount", cartCount);

            //  4. FORWARDING TO JSP
            RequestDispatcher rd = request.getRequestDispatcher("Pages/buyerDashboard.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException("Error loading products", ex);
        }
    }
}
