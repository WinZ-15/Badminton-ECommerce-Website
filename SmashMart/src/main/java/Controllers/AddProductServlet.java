package Controllers;

import Dao.ProductDAO;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProduct"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryID = Integer.parseInt(req.getParameter("categoryID"));

        Part filePart = req.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("/") + "Resources";

        // ✅ create folder if not exists
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        //  save file
        filePart.write(uploadPath + "/" + fileName);

        Product p = new Product();
        p.setName(name);
        p.setBrand(brand);
        p.setDescription(description);
        p.setPrice(price);
        p.setImage("Resources/" + fileName);
        p.setCategoryID(categoryID); 

        ProductDAO dao = new ProductDAO();
        try {
            dao.insertProduct(p);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        resp.sendRedirect("adminDashboard");
    }
}
