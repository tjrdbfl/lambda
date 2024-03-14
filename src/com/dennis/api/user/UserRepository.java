package com.dennis.api.user;

import com.dennis.api.common.UtilService;
import com.dennis.api.common.UtilServiceImpl;
import com.dennis.api.enums.Messenger;

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
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dennisdb"
                , "root", "rootroot");
        utilService = UtilServiceImpl.getInstance();
    }

    public static UserRepository getInstance() {
        return userRepository;
    }

    private Connection connection;
    private PreparedStatement pstmt;
    private UtilService utilService;


    public Messenger create() throws SQLException {
        String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY" +
                ",username VARCHAR(50),password VARCHAR(50),name VARCHAR(100)" +
                ",phone VARCHAR(20),job VARCHAR(50),height VARCHAR(10)" +
                ",weight VARCHAR(10))";

        pstmt = connection.prepareStatement(sql);
        int rs = pstmt.executeUpdate();

        pstmt.close();
        connection.close();
        return rs == 1 ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger drop() throws SQLException {
        String sql = "DROP TABLE users";
        pstmt = connection.prepareStatement(sql);
        int rs = pstmt.executeUpdate();

        pstmt.close();
        connection.close();
        return rs == 1 ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger findAll() throws SQLException {

        ResultSet resultSet = pstmt.executeQuery("select * from users");
        Map<String, User> map = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            map.put(String.valueOf(i++), User.builder()
                    .username(resultSet.getString("username"))
                    .password(resultSet.getString("password"))
                    .name(resultSet.getString("name"))
                    .phone(resultSet.getString("phone"))
                    .job(resultSet.getString("job"))
                    .height(Double.parseDouble(resultSet.getString("height")))
                    .weight(Double.parseDouble(resultSet.getString("weight")))
                    .build());
        }

        resultSet.close();
        pstmt.close();
        connection.close();

        return map.isEmpty() ? Messenger.FAIL:Messenger.SUCCESS;
    }

    public Messenger addUsers() throws SQLException {
        String sql = "INSERT INTO users (username, password, name, phone, job, height, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = connection.prepareStatement(sql);
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
        ResultSet resultSet = pstmt.executeQuery("select username,password from users");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");

        resultSet.close();
        pstmt.close();
        connection.close();
        return username.equals(user.getUsername())
                && password.equals(user.getPassword()) ?
                Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger save(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, name, phone, job, height, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = connection.prepareStatement(sql);
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
        ResultSet resultSet = pstmt.executeQuery("select * from users where ?");
        pstmt.setString(1, String.valueOf(id));
        ResultSet rs = pstmt.executeQuery();

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
            resultSet.close();
            pstmt.close();
            connection.close();
        } else {
            System.out.println("데이터가 존재 하지 않음.");
            resultSet.close();
            pstmt.close();
            connection.close();
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }

    public Messenger findUsersByName(String name) {
        return Messenger.SUCCESS;
    }

    public Messenger findUsersByJob(String job) {
        return Messenger.SUCCESS;
    }

    public Messenger count() {
        return Messenger.SUCCESS;
    }

    public Messenger createTable() {
        return Messenger.SUCCESS;
    }

    public Messenger deleteTable() {
        return Messenger.SUCCESS;
    }
}