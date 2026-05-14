package Dao;

import Model.Product;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    private Connection conn;
    private boolean isConnectionError = false;

    public ProductDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            isConnectionError = true;
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    public ArrayList<Product> getAllProducts() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setName(rs.getString("name"));
                p.setBrand(rs.getString("brand"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setImage(rs.getString("image"));
                p.setCategoryID(rs.getInt("categoryID"));
                p.setUserId(rs.getInt("userID")); //  admin/seller id
                products.add(p);
            }     
        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
        return products;
    }

    public void insertProduct(Product product) throws SQLException {
        try {
            String sql = "INSERT INTO product (name, description, brand, image, price, categoryID, userID) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getImage());
            ps.setDouble(5, product.getPrice());
            ps.setInt(6, product.getCategoryID());
            ps.setInt(7, product.getUserId());

            int rows = ps.executeUpdate();
            System.out.println("Inserted rows: " + rows);

        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    public void updateProduct(Product p) throws SQLException {
        try {
            String sql = "UPDATE product SET name=?, brand=?, description=?, price=? WHERE productID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getBrand());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getProductID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    public void deleteProduct(int id) throws SQLException {
        try {
            String sql = "DELETE FROM product WHERE productID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    public Product getProductById(int id) {
        Product product = null;
        try {
            String sql = "SELECT * FROM product WHERE productID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(
                        rs.getInt("productID"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getInt("userID"),
                        rs.getInt("categoryID")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error occurred while processing database operation");
        }
        return product;
    }

    public ArrayList<Product> getProductsByCategory(int categoryID) throws SQLException {
        ArrayList<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM product WHERE categoryID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, categoryID);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getInt("productID"));
            product.setName(rs.getString("name"));
            product.setBrand(rs.getString("brand"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setImage(rs.getString("image"));
            product.setCategoryID(rs.getInt("categoryID"));
            product.setUserId(rs.getInt("userID"));
            list.add(product);
        }
        return list;
    }

    public ArrayList<Product> searchProducts(String keyword) throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ? OR brand LIKE ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getInt("productID"));
            product.setName(rs.getString("name"));
            product.setBrand(rs.getString("brand"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setImage(rs.getString("image"));
            product.setCategoryID(rs.getInt("categoryID"));
            product.setUserId(rs.getInt("userID"));
            list.add(product);
        }
        return list;
    }

}
