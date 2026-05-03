package DOA;

import Model.Product;
import Utilities.DBConfig;
import static Utilities.DBConfig.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection conn;
    private boolean isConnectionError = false;

    public ProductDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            isConnectionError = true;
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public void insertProduct(Product p) throws SQLException {
        try {
            String sql = "INSERT INTO product (name, description, brand, stock, image, price, category_ID, user_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setString(3, p.getBrand());
            ps.setInt(4, 0); // default stock
            ps.setString(5, p.getImage());
            ps.setDouble(6, p.getPrice());
            ps.setInt(7, p.getCategoryID());
            ps.setInt(8, p.getUserId());

            int rows = ps.executeUpdate();
            System.out.println("Inserted rows: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public ArrayList<Product> getProductsBySeller(int sellerId) throws SQLException {
        ArrayList<Product> productlist = new ArrayList<>();

        try {
            String sql = "SELECT * FROM product WHERE user_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sellerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productlist.add(new Product(
                        rs.getInt("product_ID"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        sellerId
                ));
            }
            return productlist;
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public void updateProduct(Product p) throws SQLException {

        try {
            String sql = "UPDATE product SET name=?, brand=?, description=?, price=? WHERE product_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getBrand());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getProductID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());

        }
    }

    public void deleteProduct(int id) throws SQLException {

        try {
            String sql = "DELETE FROM product WHERE product_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());

        }
    }
    
    public Product getProductById(int id) {
    Product p = null;

    try {
        String sql = "SELECT * FROM product WHERE product_ID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            p = new Product(
                    rs.getInt("product_ID"),
                    rs.getString("name"),
                    rs.getString("brand"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("image"),
                    rs.getInt("user_ID")
            );
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return p;
}
}
