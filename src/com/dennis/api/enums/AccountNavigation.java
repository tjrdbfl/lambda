package com.dennis.api.enums;

import com.dennis.api.account.AccountController;

import java.util.Scanner;
import java.util.function.Predicate;

public enum AccountNavigation {  

    exit("0", (scanner)->{
        return false;
    }),
    create("1",(scanner -> {
        AccountController.createAccount(scanner);
        return true;
    })),
    deposit("2",scanner -> {
        AccountController.deposit(scanner);
        return true;
    }),
    withdraw("3", (scanner -> {
        AccountController.withdraw(scanner);
        return true;
    })),
    getBalance("4",scanner ->{
        AccountController.getBalance(scanner);
        return true;
    }),
    deleteAccount("5",scanner -> {
        AccountController.deleteAccount(scanner);
        return true;
    }),
    getAccounts("6",scanner -> {
        AccountController.getAccounts().forEach(System.out::println);
        return true;
    });
    private final String menu;
    private final Predicate<Scanner> predicate;
    AccountNavigation(String menu, Predicate<Scanner> predicate) {
        this.menu = menu;
        this.predicate = predicate;
    }


    public static boolean accountMenu(String next, Scanner sc) {
        return false;
    }
}
