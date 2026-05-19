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
}
