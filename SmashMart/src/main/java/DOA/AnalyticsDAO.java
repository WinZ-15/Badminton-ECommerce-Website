package DOA;


import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnalyticsDAO   {

    private Connection conn;
    private boolean isConnectionError = false;

    public AnalyticsDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            isConnectionError = true;
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public double getSalesThisWeek() {
        final String SQL = "SELECT SUM(total_amount) FROM `Order` WHERE YEARWEEK(order_date,1) = YEARWEEK(CURDATE(),1)";
        return runAggregateQuery(SQL);
    }


    public double getSalesThisMonth() {
        final String SQL = "SELECT SUM(total_amount) FROM `Order` WHERE MONTH(order_date)=MONTH(CURDATE()) AND YEAR(order_date)=YEAR(CURDATE())";
        return runAggregateQuery(SQL);
    }


    public double getTotalSales() {
        final String SQL = "SELECT SUM(total_amount) FROM `Order`";
        return runAggregateQuery(SQL);
    }

    // --- Helper Method ---
    private double runAggregateQuery(String sql) {
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getDouble(1) : 0.0;
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return 0.0;
        }
    }
    
}
