package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public enum NavigationOfFunction {
    Exit("x",(i)-> "x"),
    User("u",(i)-> {
        UserView.main(i);
        return "u";
    }),
    Board("b",(i)-> {
        BoardView.main(i);
        return "b";
    }),
    Account("ac",(i)-> {
        AccountView.main(i);
        return "ac";
    }),
    Crawler("c",(i)-> {
        CrawlerView.main(i);
        return "c";
    }),
    Article("a",(i)-> {
        try {
            ArticleView.main(i);
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
        System.out.printf("선택한 메뉴 : "+str);

        return Arrays.stream(values())
                .filter(i->i.name.equals(str))
                .findFirst()
                .orElseThrow()
                .function.apply(sc);
    }
}
