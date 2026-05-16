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
        String sql = "SELECT * FROM products";

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
                products.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
        return products;
    }

    public void insertProduct(Product product) throws SQLException {
        try {
            String sql = "INSERT INTO products (name, description, brand, image, price, categoryID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getImage());
            ps.setDouble(5, product.getPrice());
            ps.setInt(6, product.getCategoryID());

            int rows = ps.executeUpdate();
            System.out.println("Inserted rows: " + rows);

        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    public void updateProduct(Product p) throws SQLException {
        try {
            String sql = "UPDATE products SET name=?, brand=?, description=?, price=?, categoryID=? WHERE productID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getBrand());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getCategoryID());
            ps.setInt(6, p.getProductID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    public void deleteProduct(int id) throws SQLException {
        try {
            //  Step 1: delete related orderItems first
            String sql1 = "DELETE FROM orderItems WHERE productID=?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, id);
            ps1.executeUpdate();

            //  Step 2: delete product
            String sql2 = "DELETE FROM products WHERE productID=?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, id);
            ps2.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    public Product getProductById(int id) {
        Product product = null;
        try {
            String sql = "SELECT * FROM products WHERE productID=?";
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

        String sql = "SELECT * FROM products WHERE categoryID = ?";
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
            list.add(product);
        }
        return list;
    }

    public ArrayList<Product> searchProducts(String keyword) throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ? OR brand LIKE ?";

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
            list.add(product);
        }
        return list;
    }

}
