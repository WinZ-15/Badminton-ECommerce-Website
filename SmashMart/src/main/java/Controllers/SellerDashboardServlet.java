package Controllers;

import DOA.CategoryDAO;
import DOA.ProductDAO;
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet(name = "SellerDashboardServlet", urlPatterns = {"/sellerDashboard"})
public class SellerDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CategoryDAO cdoa = new CategoryDAO();
            ArrayList<Category> categories = cdoa.getAllCategories();
            request.setAttribute("categories", categories);

            ProductDAO pdao = new ProductDAO();
            Integer sellerId = 1;
            if (sellerId != null) {
                ArrayList<Product> products = pdao.getProductsBySeller(sellerId);
                request.setAttribute("products", products);
            }

            RequestDispatcher rd = request.getRequestDispatcher("Pages/sellerDashboard.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            throw new ServletException("Error loading dashboard data", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
