package article;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArticleController {
    private ArticleServiceImpl articleService;

    public ArticleController(){
        articleService=ArticleServiceImpl.getInstance();
    }
    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
