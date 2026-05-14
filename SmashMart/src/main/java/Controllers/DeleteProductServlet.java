package Controllers;

import Dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {

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
        resp.sendRedirect("adminDashboard");
    }
}