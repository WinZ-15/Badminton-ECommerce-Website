package Controllers;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RemoveCartItemServlet", urlPatterns = {"/removeCartItem"})
public class RemoveCartItemServlet extends HttpServlet {
    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int productId = Integer.parseInt(request.getParameter("productID"));
        HttpSession session = request.getSession();
        ArrayList<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
        if (cart != null) {
            cart.remove(Integer.valueOf(productId));
        }
        response.sendRedirect("cart");
    }
}
