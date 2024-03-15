package com.dennis.api.menus;

import com.dennis.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb",
                "root",
                "rootroot");
        pstmt = null;
        rs = null;
    }

    public static MenuRepository getInstance(){return instance;}

    public Messenger makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger removeTable() {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger insertMenus(Menu menu) {

        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            return Messenger.SQL_ERROR;
        }
    }
    public Messenger showTable() throws SQLException {
        try {
            rs = pstmt.executeQuery("select * from menus");
            while (rs.next()) {
                System.out.printf("category: %s, item: %s\n"
                        ,rs.getString("category"),rs.getString("item"));
            }
            rs.close();
            pstmt.close();
            conn.close();

            return Messenger.SUCCESS;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }
    public List<?> getMenusByCategory(String category) {
        List<String> menus = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT item FROM menus WHERE category = ?");
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while (rs.next())
                menus.add(rs.getString(1));
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }

    public Messenger returnMessenger() throws SQLException {
        String sql="";
        pstmt=conn.prepareStatement(sql);
        Messenger msg=null;
        return Messenger.SUCCESS;
    }
}
