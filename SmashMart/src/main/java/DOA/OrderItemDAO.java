
package DOA;

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
            System.out.println(e.getMessage());
        }
    }

    public boolean addOrderItem(OrderItem item) {
        try {
            String sql = "INSERT INTO order_items(order_id,product_id,quantity,subtotal) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, item.getOrderID());
            ps.setInt(2, item.getProductID());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getSubtotal());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
