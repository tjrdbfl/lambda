package com.dennis.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private ArticleServiceImpl articleService;

    public ArticleController(){
        articleService=ArticleServiceImpl.getInstance();
    }
    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
