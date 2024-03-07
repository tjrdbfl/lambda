package user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    }
    public static UserRepository getInstance(){return instance;}

    private Connection connection;
    public String test(){
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {

        String sql="select * from board";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            do {
                System.out.printf("ID: %d\tTitle: %10s\tContent: %10s\tWriter: %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
                System.out.println();
            }while (rs.next());
        }else {
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        pstmt.close();
        connection.close();
        return null;
    }
}