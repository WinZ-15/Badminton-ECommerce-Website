package Controllers;
import Dao.ProductDAO;
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
        ArrayList<Product> cartItems = new ArrayList<>();
        double total = 0;

        if (cart != null) {
            ProductDAO dao = new ProductDAO();
            // ✅ Create product count map
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int id : cart) {
                map.put(id, map.getOrDefault(id, 0) + 1);
            }

            // ✅ Convert into Product list with quantity
            for (int productId : map.keySet()) {
                Product product = dao.getProductById(productId);
                if (product!=null){
                int qty = map.get(productId);
                product.setQuantity(qty); // add field in model
                cartItems.add(product);
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