package Controllers;

import Dao.ProductDAO;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet responsible for updating product details.
 * 
 * This servlet processes the edit product form submitted
 * by the admin. It validates input data, updates the product
 * information in the database, and redirects back to the
 * admin dashboard.
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/updateProduct"})
public class UpdateProductServlet extends HttpServlet {

    /**
     * Handles POST request for updating product.
     * 
     * This method:
     * <ol>
     * <li> Retrieves updated product data from the request</li>
     * <li> Validates required fields</li>
     * <li> Creates a Product object with updated values</li>
     * <li> Updates product in the database</li>
     * <li> Redirects to admin dashboard</li>
     * </ol>
     * If validation fails, the user is redirected back to
     * the edit page with an error.
     * 
     * @param req HttpServletRequest containing updated product details
     * @param resp HttpServletResponse used for redirection
     * @throws ServletException if servlet error occurs
     * @throws IOException if IO error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Retrieve parameters from form
        int id = Integer.parseInt(req.getParameter("productID"));
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryID = Integer.parseInt(req.getParameter("categoryID"));

        //  validation
        if (name == null || name.isEmpty()) {
            resp.sendRedirect("editProduct?error=1");
            return;
        }

        // Create updated product object
        Product product = new Product();
        product.setProductID(id);
        product.setName(name);
        product.setBrand(brand);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryID(categoryID);

        // Update product in database
        ProductDAO dao = new ProductDAO();
        try {
            dao.updateProduct(product);
        } catch (SQLException ex) {
            System.out.println("Error updating product: " + ex.getMessage());
        }
        // Redirect after successful update
        resp.sendRedirect("adminDashboard");
    }
}
