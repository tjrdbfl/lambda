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
    findById("3",(i)->{
        System.out.println("3-ID 검색");
        try {
            System.out.println(UserController.getInstance().findById(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try {
            UserController.getInstance().findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    }),
    createTable("10",(i)->{
        System.out.println("10. Create_table");
        System.out.println(UserController.getInstance().createTable());
        return true;
    }),
    deleteTable("11",(i)->{
        System.out.println("11. Delete_table");
        System.out.println("회원수 " + UserController.getInstance().deleteTable());
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean select(Scanner sc) {
        System.out.println("\n\n[ MENU ] 0. EXIT\n " +
                "1. Sign_up\n " +
                "2. Login\n " +
                "3. Select_Id\n " +
                "4. Password_Change\n" +
                "5. Withdrawal\n " +
                "6. Find_user\n " +
                "7. Find_User_By_Name\n " +
                "8. Find_User_By_Job\n " +
                "9. User_Count\n " +
                "10. Create_table\n " +
                "11. Delete_table\n ");

        String str=sc.next();

        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElseThrow()
                .predicate.test(sc);
    }
}
