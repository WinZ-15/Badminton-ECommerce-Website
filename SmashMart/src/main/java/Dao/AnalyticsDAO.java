package Dao;

import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnalyticsDAO {
    private Connection conn;

    public AnalyticsDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    //  TOTAL SALES
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

    //  TOTAL ORDERS
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

    //  TOTAL USERS
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

    // TOTAL PRODUCTS
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

    //  WEEKLY SALES 
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

    // RECENT ORDERS
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