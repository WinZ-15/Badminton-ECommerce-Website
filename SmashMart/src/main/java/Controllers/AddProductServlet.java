package Controllers;

import Dao.ProductDAO;
import Model.Product;
import Utilities.ValidationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * Servlet responsible for adding new products to the system.
 *
 * This servlet handles form submission from the admin dashboard. It processes
 * product details along with image upload, stores the image on the server, and
 * inserts product data into the database.
 */
@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProduct"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class AddProductServlet extends HttpServlet {

    /**
     * Handles POST request for adding a new product.
     *
     * This method: 1. Retrieves form data (name, brand, price, etc.) 2.
     * Processes image upload 3. Saves the image to server directory 4. Creates
     * Product object 5. Inserts product into database 6. Redirects back to
     * admin dashboard
     *
     * @param req HttpServletRequest containing form data and uploaded file
     * @param resp HttpServletResponse used for redirection
     * @throws ServletException if servlet error occurs
     * @throws IOException if file handling fails
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Retrieve form parameters
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryID = Integer.parseInt(req.getParameter("categoryID"));
        // Handle file upload
        Part filePart = req.getPart("image");

        if (filePart == null || filePart.getSize() == 0) {
            req.setAttribute("error", "Please upload an image");
            req.getRequestDispatcher("adminDashboard").forward(req, resp);
            return;
        }

//  validate file type
        if (!ValidationUtil.isValidImageExtension(filePart)) {
            req.setAttribute("error", "Only JPG, JPEG, PNG, and GIF images are allowed");
            req.getRequestDispatcher("adminDashboard").forward(req, resp);
            return;
        }

        String fileName = Paths.get(filePart.getSubmittedFileName())
                .getFileName()
                .toString();
        String uploadPath = getServletContext().getRealPath("/") + "Resources";
        // Create directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Save file to server
        filePart.write(uploadPath + "/" + fileName);

        // Create product object
        Product p = new Product();
        p.setName(name);
        p.setBrand(brand);
        p.setDescription(description);
        p.setPrice(price);
        p.setImage("Resources/" + fileName);
        p.setCategoryID(categoryID);

        // Insert into database
        ProductDAO dao = new ProductDAO();
        try {
            dao.insertProduct(p);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        // Redirect to dashboard
        resp.sendRedirect(req.getContextPath() + "/adminDashboard");
    }
}
