package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public enum MainNavigationOfPredicate {
    exit("x", (scanner)->{
        return false;
    }),
    User("u",(scanner)-> {
        UserView.main(scanner);
        return true;
    }),
    Board("b",(scanner)-> {
        BoardView.main(scanner) ;
        return true;
    }),
    Account("ac",(scanner)-> {
        AccountView.main(scanner) ;
        return true;
    }),
    Crawler("c",(scanner)-> {
        CrawlerView.main(scanner) ;
        return true;
    }),
    Article("a",(scanner -> {
        try {
            ArticleView.main(scanner);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }));
    private final String mainmenu;
    private final Predicate<Scanner> predicate;
    MainNavigationOfPredicate(String mainmenu, Predicate<Scanner> consumer) {
        this.mainmenu = mainmenu;
        this.predicate = consumer;
    }

    public static boolean select(Scanner sc){
        System.out.println("=== x-Exit " +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "a-Article " +
                "===");
        String str = sc.next();
        return Arrays.stream(values())
                .filter(i->i.mainmenu.equals(str))
                .findFirst()
                .orElseThrow()
                .predicate.test(sc);
    }

}
