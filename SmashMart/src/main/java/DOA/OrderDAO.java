
package DOA;

import Model.Order;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDAO {
    private Connection conn;

    public OrderDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int createOrder(Order order) {
        try {
            String sql = "INSERT INTO orders(user_id,order_date,status,total_amount) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, order.getUserID());
            ps.setObject(2, order.getOrderDate());
            ps.setString(3, order.getStatus());
            ps.setDouble(4, order.getTotalAmount());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return -1;
    }
}
