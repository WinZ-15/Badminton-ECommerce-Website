package Dao;

import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDAO {

    private Connection conn;
    
    public OrderDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    // Create order
    public int createOrder(int userID, double total) {
        try {
            String sql = "INSERT INTO orders (userID, totalAmount, status) VALUES (?, ?, ?)";
            PreparedStatement ps
                    = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, userID);
            ps.setDouble(2, total);
            ps.setString(3, "PENDING");
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
        return -1;
    }
}
