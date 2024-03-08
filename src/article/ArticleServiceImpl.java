package article;

import common.AbstractService;
import crawler.CrawlerRepository;
import crawler.CrawlerServiceImpl;
import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService{
    private final static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleRepository articleRepository;
    private ArticleServiceImpl(){
        articleRepository=ArticleRepository.getInstance();
    }
    public static ArticleServiceImpl getInstance(){return instance;}

    @Override
    public Messenger save(Article article) {
        return null;
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Article> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Article article) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }

}
