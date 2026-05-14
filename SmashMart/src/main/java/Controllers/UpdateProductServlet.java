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

@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/updateProduct"})
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("product_ID"));
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        
        if (name == null || name.isEmpty()) {
            resp.sendRedirect("editProduct?error=1");
            return;
        }

        Product product = new Product();
        product.setProductID(id);
        product.setName(name);
        product.setBrand(brand);
        product.setDescription(description);
        product.setPrice(price);

        ProductDAO dao = new ProductDAO();
        try {
            dao.updateProduct(product);
        } catch (SQLException ex) {
            System.out.println("Error updating product: " + ex.getMessage());
        }
        resp.sendRedirect("adminDashboard");
    }
}
