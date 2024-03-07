package article;

import crawler.CrawlerRepository;
import crawler.CrawlerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{
    private static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleServiceImpl(){
        articleRepository=ArticleRepository.getInstance();
    }
    public static ArticleServiceImpl getInstance(){return instance;}

    ArticleRepository articleRepository;

    public List<?> findArticles() throws SQLException {
        return articleRepository.findArticles();
    }
}
