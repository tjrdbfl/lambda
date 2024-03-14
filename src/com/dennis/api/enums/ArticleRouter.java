package com.dennis.api.enums;

import com.dennis.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    exit("0",i->{
        System.out.println("0-종료");
        return false;
    }),
    findAll("1",i->{
        System.out.println("1-articleDB 가져오기");
        try {
            ArticleController.getInstance().findAll()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    });
    private final String name;
    private final Predicate<Scanner> predicate;

    ArticleRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean select(Scanner scanner) {
        System.out.println("\n\n[사용자메뉴] 0-종료\n " +
                "1-articleDB 가져오기\n");
        String str=scanner.next();
        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElseThrow()
                .predicate.test(scanner);
    }
}
