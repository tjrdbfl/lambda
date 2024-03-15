package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.menus.MenuController;
import com.dennis.api.user.UserView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public enum Navigation {
    exit("x", (scanner)->{
        return false;
    }),
    User("usr",(scanner)-> {
        UserView.main(scanner);
        return true;
    }),
    Board("brd",(scanner)-> {
        BoardView.main(scanner) ;
        return true;
    }),
    Account("acc",(scanner)-> {
        AccountView.main(scanner) ;
        return true;
    }),
    Crawler("cwl",(scanner)-> {
        CrawlerView.main(scanner) ;
        return true;
    }),
    Article("art",(scanner -> {
        try {
            ArticleView.main(scanner);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    })),
    Soccer("scc",(scanner -> {
        try {
            ArticleView.main(scanner);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }));
    private final String mainmenu;
    private final Predicate<Scanner> predicate;
    Navigation(String mainmenu, Predicate<Scanner> consumer) {
        this.mainmenu = mainmenu;
        this.predicate = consumer;
    }

    public static boolean select(Scanner sc) throws SQLException {

        List<?> list=MenuController.getInstance().getMenusByCategory("navigate");
        list.forEach(System.out::println);
        String str = sc.next();
        return Arrays.stream(values())
                .filter(i->i.mainmenu.equals(str))
                .findFirst()
                .orElseThrow()
                .predicate.test(sc);
    }

}
