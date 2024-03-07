package article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleService {
    public List<?> findArticles() throws SQLException;
}
