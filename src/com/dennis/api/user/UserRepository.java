package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    }

    public static UserRepository getInstance(){
        return userRepository;
    }
    private Connection connection;
    private PreparedStatement pstmt;

    public void findUsers() throws SQLException {
        ResultSet resultSet = pstmt.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        pstmt.close();
        connection.close();
    }

    public Messenger create() throws SQLException {
        String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY" +
                ",username VARCHAR(50),password VARCHAR(50),name VARCHAR(100)" +
                ",phone VARCHAR(20),job VARCHAR(50),height VARCHAR(10)" +
                ",weight VARCHAR(10))";

        pstmt=connection.prepareStatement(sql);
        int rs=pstmt.executeUpdate();

        pstmt.close();
        connection.close();
        return rs==1 ? Messenger.SUCCESS:Messenger.FAIL;
    }

    public Messenger drop() throws SQLException {
        String sql = "DROP TABLE users";
        pstmt=connection.prepareStatement(sql);
        int rs=pstmt.executeUpdate();

        pstmt.close();
        connection.close();
        return rs==1 ? Messenger.SUCCESS:Messenger.FAIL;
    }

    public List<User> findAll() throws SQLException {
        ResultSet resultSet = pstmt.executeQuery("select * from users");

        List<User> list=new ArrayList<>();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        pstmt.close();
        connection.close();
        return ;
    }
}