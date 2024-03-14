package com.dennis.api.article;

import java.sql.SQLException;
import java.util.Scanner;
import com.dennis.api.enums.ArticleRouter;

public class ArticleView {
    public static void main(Scanner scanner) throws SQLException {
        while(ArticleRouter.select(scanner));
    }
}
