package article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private final static ArticleRepository instance;

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

    public List<?> findAll() throws SQLException {
        List<Article> ls=new ArrayList<>();
        String sql="select * from articles";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery();

        if(rs.next()){
            do{
                ls.add(Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .writer(rs.getString("writer"))
                        .content(rs.getString("content"))
                        .registerDate(rs.getString("register_date"))
                        .build());
            }while (rs.next());
        }else {
            System.out.println("No Data");
        }

        rs.close();
        preparedStatement.close();
        connection.close();
        return ls;
    }
}
