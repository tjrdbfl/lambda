package com.dennis.api;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "b-Board " +
                    "ac-Account " +
                    "c-Crawler " +
                    "a-Article " +
                    "===");
            switch (sc.next()){
                case "x":  return;
                case "u": UserView.main(sc);break;
                case "b": BoardView.main(); break;
                case "ac": AccountView.main(sc); break;
                case "c": CrawlerView.main(sc);break;
                case "a": ArticleView.main(sc);break;

            }
        }
    }
}