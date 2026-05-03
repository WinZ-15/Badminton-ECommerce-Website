package Controllers;

import DOA.ProductDAO;
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

        Product p = new Product();
        p.setProductID(id);
        p.setName(name);
        p.setBrand(brand);
        p.setDescription(description);
        p.setPrice(price);

        ProductDAO dao = new ProductDAO();
        try {
            dao.updateProduct(p);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServletException("Update failed", ex);
        }

        resp.sendRedirect("sellerDashboard");
    }
}
