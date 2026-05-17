package Dao;

import Model.Order;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for managing Order data.
 * 
 * This class handles database operations related to orders,
 * such as creating a new order and retrieving existing orders.
 * It is mainly used during the checkout process and for admin analytics.
 */
public class OrderDAO {
    /** Database connection instance */
    private Connection conn;

    /**
     * Constructor to initialize database connection.
     */
    public OrderDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    /**
     * Creates a new order in the database.
     * 
     * This method inserts a new order record and returns
     * the generated order ID. The default status is set to "PENDING".
     * 
     * @param userID ID of the user placing the order
     * @param total total amount of the order
     * @return generated order ID if successful, -1 otherwise
     */
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

    /**
     * Retrieves all orders from the database.
     * 
     * Orders are sorted by creation time.
     * 
     * @return list of all orders
     */
    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orders ORDER BY createdAt";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setUserID(rs.getInt("userID"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setCreatedAt(rs.getTimestamp("createdAt"));
                list.add(order);
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching orders: " + ex.getMessage());
        }
        return list;
    }
}