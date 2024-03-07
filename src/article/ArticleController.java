package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    ArticleServiceImpl articleService;

    public ArticleController(){
        articleService=ArticleServiceImpl.getInstance();
    }
    public List<?> findArticles() throws SQLException {
        return articleService.findArticles();
    }
}
