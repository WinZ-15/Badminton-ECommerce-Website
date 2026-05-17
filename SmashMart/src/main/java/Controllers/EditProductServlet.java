package Controllers;

import Dao.CategoryDAO;
import Dao.ProductDAO;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet responsible for loading the Edit Product page.
 * 
 * This servlet retrieves the selected product details based on
 * the provided product ID and forwards the data to the edit
 * product JSP page. It also loads available categories so the
 * admin can update the product category.
 */
@WebServlet(name = "EditProductServlet", urlPatterns = {"/editProduct"})
public class EditProductServlet extends HttpServlet {

    /**
     * Handles GET request to display the edit product form.
     * 
     * This method:
     * 1. Retrieves product ID from request
     * 2. Loads product details from database
     * 3. Loads all categories for dropdown selection
     * 4. Forwards data to editProduct.jsp
     * 
     * If product ID is invalid or data is not found,
     * the user is redirected to the admin dashboard.
     * 
     * @param req HttpServletRequest containing product ID
     * @param resp HttpServletResponse used for forwarding/redirecting
     * @throws ServletException if servlet error occurs
     * @throws IOException if IO error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // Load categories for dropdown
            CategoryDAO cdao = new CategoryDAO();
            req.setAttribute("categories", cdao.getAllCategories());

            // Get product ID from request
            String idParam = req.getParameter("productID");
            if (idParam == null || idParam.isEmpty()) {
                resp.sendRedirect("adminDashboard");
                return;
            }

            int id = Integer.parseInt(idParam);

            // Load product by ID
            ProductDAO dao = new ProductDAO();
            Product product = dao.getProductById(id);

            // If product not found, redirect
            if (product == null) {
                resp.sendRedirect("adminDashboard");
                return;
            }

            // Set product attribute for editing
            req.setAttribute("product", product);

            // Forward to edit page
            req.getRequestDispatcher("Pages/editProduct.jsp").forward(req, resp);

        } catch (Exception e) {
            // Redirect on error
            resp.sendRedirect("adminDashboard");
        }
    }
}