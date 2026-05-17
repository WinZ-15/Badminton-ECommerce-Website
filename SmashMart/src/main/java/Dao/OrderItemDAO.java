package Dao;

import Model.OrderItem;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Data Access Object (DAO) class for managing OrderItem data.
 * 
 * This class handles database operations related to order items,
 * such as inserting items into an order. It is used during the
 * checkout process to store ordered products.
 */
public class OrderItemDAO {
    /** Database connection instance */
    private Connection conn;

    /**
     * Constructor to initialize database connection.
     */
    public OrderItemDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    /**
     * Adds a new item to an order.
     * 
     * This method inserts a record into the orderItems table,
     * linking a product with an order along with quantity and subtotal.
     * 
     * @param orderID ID of the order
     * @param productID ID of the product
     * @param qty quantity of the product ordered
     * @param subtotal total cost for this item (price × quantity)
     * @return true if insertion is successful, false otherwise
     */
    public boolean addOrderItem(int orderID, int productID, int qty, double subtotal) {
        try {
            String sql = "INSERT INTO orderItems(orderID, productID, quantity, subtotal) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            ps.setInt(3, qty);
            ps.setDouble(4, subtotal);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            return false;
        }
    }
}