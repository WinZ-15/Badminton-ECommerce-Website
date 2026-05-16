package Controllers;
import Dao.ProductDAO;
import Model.CartItem;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
        ArrayList<CartItem> cartItems = new ArrayList<>();
        double total = 0;

        if (cart != null) {
            ProductDAO dao = new ProductDAO();
            // Create product count map
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int id : cart) {
                map.put(id, map.getOrDefault(id, 0) + 1);
            }

            //  Convert into Product list with quantity
            for (int productId : map.keySet()) {
                Product product = dao.getProductById(productId);
                if (product!=null){
                int qty = map.get(productId);
                CartItem item = new CartItem(product,qty); 
                cartItems.add(item);
                total += product.getPrice() * qty;
            }
            }
        }
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("cartTotal", total);
        request.getRequestDispatcher("Pages/cart.jsp")
               .forward(request, response);
    }
}