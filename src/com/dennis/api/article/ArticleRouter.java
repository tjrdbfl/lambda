package com.dennis.api.article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleRouter {
    public static void main(Scanner scanner) throws SQLException {
        ArticleController articleController=new ArticleController();

        while(true){
            System.out.println("\n[사용자메뉴] 0-종료\n " +
                    "1-articleDB 가져오기\n");
            switch (scanner.next()){
                case "0":
                    System.out.println("0-종료");return;
                case "1":
                    System.out.println("1-articleDB 가져오기");
                    articleController.findAll()
                            .forEach(i -> System.out.println(i));
                    break;
            }
        }
    }
}