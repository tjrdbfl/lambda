package article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private ArticleRepository() throws SQLException {
        connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb","root","rootroot"
        );
    }
    public static ArticleRepository getInstance(){return instance;}
    Connection connection;
    public List<?> findArticles() throws SQLException {
        String sql="select * from articles";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery();
        List<Article> list=new ArrayList<>();

        if(rs.next()){
            do{
                list.add(Article.builder()
                                .id(rs.getInt("id"))
                                .title(rs.getString("title"))
                                .content(rs.getString("content"))
                                .writer(rs.getString("writer"))
                                .build());
            }while (rs.next());
        }else {
            System.out.println("null");
        }
        return list;
    }
}
