package com.dennis.api.enums;

import com.dennis.api.account.AccountRouter;
import com.dennis.api.article.ArticleRouter;
import com.dennis.api.board.BoardRouter;
import com.dennis.api.crawler.CrawlerRouter;
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
        BoardRouter.main(scanner) ;
        return true;
    }),
    Account("ac",(scanner)-> {
        AccountRouter.main(scanner) ;
        return true;
    }),
    Crawler("c",(scanner)-> {
        CrawlerRouter.main(scanner) ;
        return true;
    }),
    Article("a",(scanner -> {
        try {
            ArticleRouter.main(scanner);
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
