package Dao;

import Model.Category;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for managing Category data.
 * 
 * This class provides methods to perform database operations
 * related to product categories such as retrieving, adding,
 * deleting, and searching categories.
 * It is used to support category management and filtering features.
 */
public class CategoryDAO {
    /** Database connection instance */
    private Connection conn;

    /**
     * Constructor to initialize database connection.
     */
    public CategoryDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    /**
     * Retrieves all categories from the database.
     * 
     * @return list of all categories
     */
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM categories";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getInt("categoryID"));
                category.setCategoryName(rs.getString("categoryName"));
                list.add(category);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return list;
    }

    /**
     * Adds a new category to the database.
     * 
     * @param category Category object containing category name
     * @return true if insertion is successful, false otherwise
     */
    public boolean addCategory(Category category) {
        try {
            String sql = "INSERT INTO categories(categoryName) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Deletes a category from the database.
     * 
     * @param id category ID to delete
     * @return true if deletion is successful, false otherwise
     */
    public boolean deleteCategory(int id) {
        try {
            String sql = "DELETE FROM categories WHERE categoryID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retrieves a category by its ID.
     * 
     * @param id category ID to search for
     * @return Category object if found, null otherwise
     */
    public Category getCategoryById(int id) {
        try {
            String sql = "SELECT * FROM categories WHERE categoryID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt("categoryID"));
                c.setCategoryName(rs.getString("categoryName"));
                return c;
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return null;
    }
}
