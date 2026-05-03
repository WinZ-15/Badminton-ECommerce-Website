
import DOA.ProductDAO;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProductServlet", urlPatterns = {"/editProduct"})
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String idParam = req.getParameter("product_ID");

            if (idParam == null || idParam.isEmpty()) {
                resp.sendRedirect("sellerDashboard");
                return;
            }

            int id = Integer.parseInt(idParam);

            ProductDAO dao = new ProductDAO();
            Product product = dao.getProductById(id);

            if (product == null) {
                resp.sendRedirect("sellerDashboard");
                return;
            }

            req.setAttribute("product", product);
            req.getRequestDispatcher("Pages/editProduct.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect("sellerDashboard");
        }
    }
}