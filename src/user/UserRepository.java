package user;

import common.UtilService;
import common.UtilServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class UserRepository {
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb"
                , "root", "rootroot");
        utilService = UtilServiceImpl.getInstance();

    }

    public static UserRepository getInstance() {
        return instance;
    }

    private Connection connection;
    private UtilService utilService;
    private PreparedStatement pstmt;
    private int rowsAffected;

    public List<?> findUsers() throws SQLException {

        String sql = "select * from users";
        pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.printf("ID: %d\tTitle: %10s\tContent: %10s\tWriter: %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        pstmt.close();
        connection.close();
        return null;
    }

    public String touch() throws SQLException {
        String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY" +
                ",username VARCHAR(50),password VARCHAR(50),name VARCHAR(100)" +
                ",phone VARCHAR(20),job VARCHAR(50),height VARCHAR(10)" +
                ",weight VARCHAR(10))";
        pstmt = connection.prepareStatement(sql);
        int rs = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        if (rs > 0)
            return "테이블 생성 성공";
        else return "테이블 생성 실패";
    }

    public String rm() throws SQLException {
        String msg;
        String sql = "DROP TABLE users";
        pstmt = connection.prepareStatement(sql);
        if (pstmt.executeUpdate() == 1)
            msg = "테이블 제거 성공";
        else msg = "테이블 제거 실패";

        pstmt.close();
        connection.close();

        return msg;
    }

    public String addUsers() throws SQLException {
        String sql;
        sql = "SHOW TABLES LIKE 'users'";
        pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            sql = "INSERT INTO users (username, password, name, phone, job, height, weight) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, utilService.createRandomUsername());
            pstmt.setString(2, utilService.createRandomUsername().concat(utilService.createRandomUsername()));
            pstmt.setString(3, utilService.createRandomName());
            pstmt.setString(4, "010-0000-0000");
            pstmt.setString(5, utilService.createRandomJob());
            pstmt.setString(6, String.valueOf(utilService.createRandomDouble(140, 50)));
            pstmt.setString(7, String.valueOf(utilService.createRandomDouble(35, 100)));
            rowsAffected += pstmt.executeUpdate();
        } else {
            return "존재하지 않는 테이블";
        }

        pstmt.close();

        return rowsAffected + "개 더미값 추가";
    }
}