package Controllers;

import Dao.OrderDAO;
import Dao.OrderItemDAO;
import Dao.ProductDAO;
import Model.Product;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOut"})
public class CheckOutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();

        //  Get user
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
            return;
        }

        //   Get cart from session 
        ArrayList<Integer> cart =
                (ArrayList<Integer>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart");
            return;
        }

        try {
            ProductDAO pdao = new ProductDAO();
            OrderDAO orderDAO = new OrderDAO();
            OrderItemDAO itemDAO = new OrderItemDAO();   // ✅ FIX

            //  Count quantities
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int id : cart) {
                map.put(id, map.getOrDefault(id, 0) + 1);
            }
            double total = 0;

            //  Calculate total price
            for (int productId : map.keySet()) {
                Product p = pdao.getProductById(productId);
                int qty = map.get(productId);
                if (p != null) {
                    total += p.getPrice() * qty;
                }
            }

            //  Create Order
            int orderID = orderDAO.createOrder(user.getUserID(), total);
            if (orderID == -1) {
                response.sendRedirect("cart?error=1");
                return;
            }

            //  nsert Order Items ✅ FIX
            for (int productId : map.keySet()) {
                Product p = pdao.getProductById(productId);
                int qty = map.get(productId);
                if (p != null) {
                    double subtotal = p.getPrice() * qty;
                      itemDAO.addOrderItem(orderID, productId, qty, subtotal);
                }
            }

            // Clear cart
            session.removeAttribute("cart");

            //  Redirect
            response.sendRedirect(request.getContextPath() + "/buyerDashboard?success=1");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}