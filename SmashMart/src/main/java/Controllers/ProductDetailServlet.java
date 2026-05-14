package Controllers;

import Dao.ProductDAO;
import Model.Product;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/productDetail"})
public class ProductDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                //checking if it null and preparing early exit
                String idProductCheck = request.getParameter("product_ID");
                if (idProductCheck == null) {
                response.sendRedirect("buyerDashboard");
                return;
            }

            // turn product id to integer using parseInt
           int productID = Integer.parseInt(idProductCheck);

            // Load product from DB
            ProductDAO dao = new ProductDAO();
            Product product = dao.getProductById(productID);

            // Send to JSP
            request.setAttribute("product", product);
            RequestDispatcher rd =
                request.getRequestDispatcher("Pages/productDetails.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            throw new ServletException("Error loading product details", e);
        }
    }
}
