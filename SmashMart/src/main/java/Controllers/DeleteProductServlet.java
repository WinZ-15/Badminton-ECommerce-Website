package Controllers;

import Dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet responsible for deleting a product from the system.
 * 
 * This servlet handles requests from the admin dashboard when
 * a delete action is performed. It retrieves the product ID from
 * the request and removes the product from the database.
 */
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {
    /**
     * Handles POST request for deleting a product.
     * 
     * This method:
     * 1. Retrieves the product ID from the request
     * 2. Calls ProductDAO to delete the product
     * 3. Redirects back to admin dashboard
     * 
     * @param req HttpServletRequest containing product ID
     * @param resp HttpServletResponse used for redirection
     * @throws ServletException if servlet error occurs
     * @throws IOException if IO error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("productID"));
            ProductDAO dao = new ProductDAO();
            dao.deleteProduct(id);
        } catch (SQLException | NumberFormatException ex) {
            System.out.println("Error deleting product: " + ex.getMessage());
        }
        // Redirect back to dashboard after deletion
        resp.sendRedirect("adminDashboard");
    }
}
