package com.dennis.api.enums;

import com.dennis.api.account.AccountController;

import java.util.Scanner;
import java.util.function.Predicate;

public enum AccountNavigationOfPredicate {

    exit("exit", (scanner)->{
        return false;
    }),
    create("create",(scanner -> {
        AccountController.createAccount(scanner);
        return true;
    })),
    deposit("deposit",scanner -> {
        AccountController.deposit(scanner);
        return true;
    }),
    withdraw("withdraw", (scanner -> {
        AccountController.withdraw(scanner);
        return true;
    })),
    getBalance("getBalance",scanner ->{
        AccountController.getBalance(scanner);
        return true;
    }),
    deleteAccount("deleteAccount",scanner -> {
        AccountController.deleteAccount(scanner);
        return true;
    }),
    getAccounts("getAccounts",scanner -> {
        AccountController.getAccounts().forEach(System.out::println);
        return true;
    });
    private final String menu;
    private final Predicate<Scanner> predicate;
    AccountNavigationOfPredicate(String menu, Predicate<Scanner> predicate) {
        this.menu = menu;
        this.predicate = predicate;
    }


    public static boolean accountMenu(Scanner sc) {
        System.out.println("[Account] 0-Exit 1-Create 2-Deposit " +
                "3-Withdraw 4-Balance 5-Remove 6-Account List");
        return false;
    }
}
