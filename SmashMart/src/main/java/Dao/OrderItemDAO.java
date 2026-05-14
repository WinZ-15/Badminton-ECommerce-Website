package Dao;

import Model.OrderItem;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderItemDAO {

    private Connection conn;

    public OrderItemDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
           System.out.println("Database Connection Error: " + e.getMessage());
        }
    }
 //add item to order
public boolean addOrderItem(int orderID, int productID, int qty, double subtotal) {
    try {
        String sql = "INSERT INTO order_items(orderID, productID, quantity, subtotal) VALUES (?, ?, ?, ?)";
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
