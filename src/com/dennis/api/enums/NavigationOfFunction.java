package com.dennis.api.enums;

import com.dennis.api.account.AccountRouter;
import com.dennis.api.article.ArticleRouter;
import com.dennis.api.board.BoardRouter;
import com.dennis.api.crawler.CrawlerRouter;
import com.dennis.api.user.UserView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public enum NavigationOfFunction {
    Exit("exit",(scanner)-> {return "x";}),
    User("user",(i)-> {
        UserView.main(i);
        return "u";
    }),
    Board("board",(i)-> {
        BoardRouter.main(i);
        return "b";
    }),
    Account("account",(i)-> {
        AccountRouter.main(i);
        return "ac";
    }),
    Crawler("crawler",(i)-> {
        CrawlerRouter.main(i);
        return "c";
    }),
    Article("article",(i)-> {
        try {
            ArticleRouter.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "a";})
    ;
    private final String name;
    private final Function<Scanner,String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }
    public static String select(Scanner sc){
        System.out.println("=== x-Exit " +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "a-Article " +
                "===");

        String str = sc.next();

        return Arrays.stream(values()).toString();
    }
}
