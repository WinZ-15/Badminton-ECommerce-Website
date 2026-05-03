package DOA;

import Model.Category;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDAO {

    private Connection conn;

    public CategoryDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt("category_ID"));
                c.setCategoryName(rs.getString("category_name"));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean addCategory(Category category) {
        try {
            String sql = "INSERT INTO category(category_name) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean deleteCategory(int id) {
        try {
            String sql = "DELETE FROM category WHERE category_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

 
    public Category getCategoryById(int id) {
        try {
            String sql = "SELECT * FROM category WHERE category_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt("category_ID"));
                c.setCategoryName(rs.getString("category_name"));
                return c;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
