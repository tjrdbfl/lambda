package com.dennis.api.user;

import com.dennis.api.common.UtilService;
import com.dennis.api.common.UtilServiceImpl;
import com.dennis.api.enums.Messenger;
import com.dennis.api.soccer.SoccerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserRepository {

    private final static UserRepository userRepository;

    static {
        try {
            userRepository = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserRepository() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dennisdb"
                , "root", "rootroot");
        utilService = UtilServiceImpl.getInstance();
    }

    public static UserRepository getInstance() {
        return userRepository;
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private int res;
    private UtilService utilService;

    public Messenger findAll() throws SQLException {

        rs = pstmt.executeQuery("select * from users");
        Map<String, User> map = new HashMap<>();
        int i = 0;
        while (rs.next()) {
            map.put(String.valueOf(i++), User.builder()
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .name(rs.getString("name"))
                    .phone(rs.getString("phone"))
                    .job(rs.getString("job"))
                    .height(Double.parseDouble(rs.getString("height")))
                    .weight(Double.parseDouble(rs.getString("weight")))
                    .build());
        }

        rs.close();
        pstmt.close();
        conn.close();

        return map.isEmpty() ? Messenger.FAIL:Messenger.SUCCESS;
    }

    public Messenger addUsers() throws SQLException {
        String sql = "INSERT INTO users (username, password, name, phone, job, height, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, utilService.createRandomUsername());
        pstmt.setString(2, utilService.createRandomUsername().concat(utilService.createRandomUsername()));
        pstmt.setString(3, utilService.createRandomName());
        pstmt.setString(4, "010-0000-0000");
        pstmt.setString(5, utilService.createRandomJob());
        pstmt.setString(6, String.valueOf(utilService.createRandomDouble(140, 50)));
        pstmt.setString(7, String.valueOf(utilService.createRandomDouble(35, 100)));
        pstmt.close();

        return Messenger.SUCCESS;
    }

    public Messenger login(User user) throws SQLException {
        rs = pstmt.executeQuery("select username,password from users");
        String username = rs.getString("username");
        String password = rs.getString("password");

        rs.close();
        pstmt.close();
        conn.close();
        return username.equals(user.getUsername())
                && password.equals(user.getPassword()) ?
                Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger save(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, name, phone, job, height, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getUsername());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getJob());
        pstmt.setString(6, String.valueOf(user.getHeight()));
        pstmt.setString(7, String.valueOf(user.getWeight()));
        pstmt.close();

        return Messenger.SUCCESS;
    }

    public Messenger findById(int id) throws SQLException {
        rs = pstmt.executeQuery("select * from users where ?");
        pstmt.setString(1, String.valueOf(id));
        rs = pstmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.printf("ID : %d \t username : %s \t name : %s \t phone : %s \t" +
                                " job : %s \t height : %.2f \t weight : %.2f\n",
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("job"),
                        rs.getFloat("height"),
                        rs.getFloat("weight"));
                System.out.println();
            } while (rs.next());
            rs.close();
            pstmt.close();
            conn.close();
        } else {
            System.out.println("데이터가 존재 하지 않음.");
            rs.close();
            pstmt.close();
            conn.close();
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }

    public Messenger findUsersByName(String name) throws SQLException {
        try {
            String sql = "SELECT name FROM users WHERE name = ?";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next())
                if(rs.getString("name").equals(name))
                    return Messenger.SUCCESS;
            return Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return Messenger.FAIL;
        } finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
    }

    public Messenger findUsersByJob(String job) throws SQLException {
        try {
            pstmt=conn.prepareStatement("select job from users where job=?");
            rs=pstmt.executeQuery();
            while (rs.next())
                if(rs.getString("job").equals(job))
                    return Messenger.SUCCESS;
            return Messenger.FAIL;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return Messenger.FAIL;
        }finally {
            pstmt.close();
            rs.close();
            conn.close();
        }
    }

    public Messenger count() throws SQLException {
        try {
            pstmt=conn.prepareStatement("select count(*) from users");
            System.out.println(pstmt.executeUpdate());
            return Messenger.SUCCESS;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return Messenger.FAIL;
        }finally {
            pstmt.close();
            rs.close();
            conn.close();
        }
    }

    public Messenger createTable() throws SQLException {
        String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY" +
                ",username VARCHAR(50),password VARCHAR(50),name VARCHAR(100)" +
                ",phone VARCHAR(20),job VARCHAR(50),height VARCHAR(10)" +
                ",weight VARCHAR(10))";

        pstmt = conn.prepareStatement(sql);
        int res = pstmt.executeUpdate();

        pstmt.close();
        conn.close();
        return res == 1 ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger deleteTable() throws SQLException {
        String sql = "DROP TABLE users";
        pstmt = conn.prepareStatement(sql);
        res = pstmt.executeUpdate();

        pstmt.close();
        conn.close();
        return res == 1 ? Messenger.SUCCESS : Messenger.FAIL;
    }
}