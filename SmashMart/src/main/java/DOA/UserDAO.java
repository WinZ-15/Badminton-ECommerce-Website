package DOA;

import Model.User;
import Utilities.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private Connection conn;
    private boolean isConnectionError = false;

    public UserDAO() {
        try {
            conn = DBConfig.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            isConnectionError = true;
            System.out.println(ex.getLocalizedMessage());
        }
    }


    public boolean registerUser(User user) {
        try {
            final String INSERT_USER = "INSERT INTO User(name,email,password,role,address,phone) VALUES(?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(INSERT_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhone());
            int result = ps.executeUpdate();
            return (result > 0);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }


    public User loginUser(String email, String password) {
        try {
            final String LOGIN_SQL = "SELECT * FROM User WHERE email=? AND password=?;";
            PreparedStatement ps = conn.prepareStatement(LOGIN_SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("user_ID"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setAddress(rs.getString("address"));
                u.setPhone(rs.getString("phone"));
                return u;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }


    public User getUserByEmail(String email) {
        try {
            final String SQL = "SELECT * FROM User WHERE email=?;";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("user_ID"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setAddress(rs.getString("address"));
                u.setPhone(rs.getString("phone"));
                return u;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }
}
