package com.dennis.api.enums;

import com.dennis.api.account.AccountController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {

    exit("0", (scanner)->false),
    create("1",(scanner -> {
        AccountController.getInstance().createAccount(scanner);
        return true;
    })),
    deposit("2",scanner -> {
        AccountController.getInstance().deposit(scanner);
        return true;
    }),
    withdraw("3", (scanner -> {
        AccountController.getInstance().withdraw(scanner);
        return true;
    })),
    getBalance("4",scanner ->{
        AccountController.getInstance().getBalance(scanner);
        return true;
    }),
    deleteAccount("5",scanner -> {
        AccountController.getInstance().deleteAccount(scanner);
        return true;
    }),
    getAccounts("6",scanner -> {
        AccountController.getInstance().getAccounts().forEach(System.out::println);
        return true;
    });
    private final String menu;
    private final Predicate<Scanner> predicate;
    AccountRouter(String menu, Predicate<Scanner> predicate) {
        this.menu = menu;
        this.predicate = predicate;
    }

    public static boolean select(Scanner sc) {
        System.out.println("[Account] 0-Exit 1-Create 2-Deposit " +
                "3-Withdraw 4-Balance 5-Remove 6-Account List");
        String str=sc.next();
        return Stream.of(values())
                .filter(i->i.menu.equals(str))
                .findAny().orElseThrow()
                .predicate.test(sc);
    }
}
