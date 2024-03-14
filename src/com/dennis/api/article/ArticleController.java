package com.dennis.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private final static ArticleController articleController=new ArticleController();
    private ArticleServiceImpl articleService;

    private ArticleController(){
        articleService=ArticleServiceImpl.getInstance();
    }
    public static ArticleController getInstance(){
        return articleController;
    }
    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
