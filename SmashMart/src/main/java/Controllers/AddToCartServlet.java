package Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "/AddToCartServlet", urlPatterns = {"/addProductCart"})
public class AddToCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int productId = Integer.parseInt(request.getParameter("productID"));
        int qty = Integer.parseInt(request.getParameter("qty"));

        HttpSession session = request.getSession();

        ArrayList<Integer> cart =
                (ArrayList<Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        for (int i = 0; i < qty; i++) {
            cart.add(productId);
        }

        session.setAttribute("cart", cart);

      response.sendRedirect(request.getContextPath() + "/buyerDashboard?added=1");
    }
}