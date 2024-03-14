package com.dennis.api.enums;

import com.dennis.api.user.UserController;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    exit("0",(i)->{
        System.out.println("0-종료");
        return false;
    }),
    save("1",(i)->{
        System.out.println("1-회원가입");
        try {
            System.out.println("회원가입 결과 : "
                    + UserController.getInstance().save(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    login("2",(i)->{
        System.out.println("2-로그인");
        try {
            System.out.println("로그인 결과 : "
                    + UserController.getInstance().login(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    getOne("3",(i)->{
        System.out.println("3-ID 검색");
        System.out.println(UserController.getInstance().getOne(i));
        return true;
    }),
    updatePassword("4",(i)->{
        System.out.println("4-비번변경");
        System.out.println(UserController.getInstance().updatePassword(i));
        return true;
    }),
    delete("5",(i)->{
        System.out.println("5-탈퇴");
        System.out.println(UserController.getInstance().delete(i));
        return true;
    }),
    getUserMap("6",(i)->{
        System.out.println("6-회원목록");
        UserController.getInstance().getUserMap().forEach((k, v) -> {
            System.out.printf("아이디: %s, 회원정보: %s", k, v);
        });
        return true;
    }),
    findUsersByName("7",(i)->{
        System.out.println("7-이름검색");
        System.out.println(UserController.getInstance().findUsersByName(i));
        return true;
    }),
    findUsersByJob("8",(i)->{
        System.out.println("8-직업검색");
        System.out.println(UserController.getInstance().findUsersByJob(i));
        return true;
    }),
    count("9",(i)->{
        System.out.println("9-회원수");
        System.out.println("회원수 " + UserController.getInstance().count());
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean select(Scanner sc) {
        System.out.println("\n\n[사용자메뉴] 0-종료\n " +
                "1-회원가입\n " +
                "2-로그인\n " +
                "3-ID검색\n " +
                "4-비번변경\n" +
                "5-탈퇴\n " +
                "6-회원목록\n " +
                "7-이름검색\n " +
                "8-직업검색\n " +
                "9-회원수");

        String str=sc.next();

        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElseThrow()
                .predicate.test(sc);
    }
}
