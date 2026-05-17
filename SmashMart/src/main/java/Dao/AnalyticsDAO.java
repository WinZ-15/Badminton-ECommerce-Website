package Dao;

import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for handling analytics data.
 * 
 * This class provides methods to retrieve statistical information
 * from the database such as total sales, total orders, total users,
 * total products, and recent orders. It is mainly used in the admin dashboard
 * to display analytical insights.
 */
public class AnalyticsDAO {
    /** Database connection instance */
    private Connection conn;

    /**
     * Constructor to initialize database connection.
     */
    public AnalyticsDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    /**
     * Retrieves the total sales amount from all orders.
     * 
     * @return total sales value
     */
    public double getTotalSales() {
        double total = 0;
        try {
            String sql = "SELECT SUM(totalAmount) FROM orders";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return total;
    }

    /**
     * Retrieves the total number of orders.
     * 
     * @return total order count
     */
    public int getTotalOrders() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM orders";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return count;
    }

    /**
     * Retrieves the total number of users.
     * 
     * @return total user count
     */
    public int getTotalUsers() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return count;
    }

    /**
     * Retrieves the total number of products.
     * 
     * @return total product count
     */
    public int getTotalProducts() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM products";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return count;
    }

    /**
     * Retrieves total sales for the current week.
     * 
     * This method calculates the sum of order amounts
     * for orders created in the current week.
     * 
     * @return total weekly sales amount
     */
    public double getSalesThisWeek() {
        double total = 0;
        try {
            String sql = "SELECT SUM(totalAmount) FROM orders "
                       + "WHERE YEARWEEK(createdAt,1)=YEARWEEK(CURDATE(),1)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return total;
    }

    /**
     * Retrieves recent orders from the database.
     * 
     * This method returns a list of the most recent orders,
     * limited to the last 5 entries, sorted by creation date.
     * 
     * @return list of recent orders as formatted strings
     */
    public ArrayList<String> getRecentOrders() {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "SELECT orderID, totalAmount FROM orders ORDER BY createdAt DESC LIMIT 5";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String data = "Order ID: " + rs.getInt("orderID")
                        + " | Total: " + rs.getDouble("totalAmount");
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return list;
    }
}