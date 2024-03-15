package com.dennis.api.enums;

import com.dennis.api.user.UserController;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    exit("x",(i)->{
        System.out.println("x: EXIT");
        return false;
    }),
    join("join",(i)->{
        System.out.println("join: Join");
        try {
            System.out.println("회원가입 결과 : "
                    + UserController.getInstance().save(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    login("login",(i)->{
        System.out.println("login: Login");
        try {
            System.out.println("로그인 결과 : "
                    + UserController.getInstance().login(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    findById("cat-id",(i)->{
        System.out.println("cat-id: Find_Id");
        try {
            System.out.println(UserController.getInstance().findById(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    updatePassword("ch-pw",(i)->{
        System.out.println("ch-pw: Password_Change");
        System.out.println(UserController.getInstance().updatePassword(i));
        return true;
    }),
    withdrawal("withdrawal",(i)->{
        System.out.println("withdrawal: Withdrawal");
        System.out.println(UserController.getInstance().withdrawal(i));
        return true;
    }),
    getUserMap("ls-a",(i)->{
        System.out.println("ls-a: Find_user");
        try {
            UserController.getInstance().findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    findUsersByName("ls-n",(i)->{
        System.out.println("ls-n: Find_User_By_Name");
        try {
            System.out.println(UserController.getInstance().findUsersByName(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    findUsersByJob("ls-job",(i)->{
        System.out.println("ls-job: Find_User_By_Job");
        try {
            System.out.println(UserController.getInstance().findUsersByJob(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    count("cnt",(i)->{
        System.out.println("cnt: User_Count");
        try {
            System.out.println("회원수 " + UserController.getInstance().count());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    createTable("mk",(i)->{
        System.out.println("mk : User Table");
        try {
            System.out.println(UserController.getInstance().createTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    deleteTable("rm",(i)->{
        System.out.println("rm : Delete_table");
        try {
            System.out.println("회원수 " + UserController.getInstance().deleteTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean select(Scanner sc) {
        System.out.println("\n\n[ MENU ] x: EXIT\n " +
                "join: Join\n " +
                "login: Login\n " +
                "cat-id: Find_Id\n " +
                "ch-pw: Password_Change\n" +
                "withdrawal: Withdrawal\n " +
                "ls-a: Find_user\n " +
                "ls-n: Find_User_By_Name\n " +
                "ls-job: Find_User_By_Job\n " +
                "cnt: User_Count\n " +
                "mk : User Table\n " +
                "rm : Delete_table\n ");

        String str=sc.next();

        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElseThrow()
                .predicate.test(sc);
    }
}
