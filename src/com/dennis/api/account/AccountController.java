package com.dennis.api.account;

import com.dennis.api.enums.Messenger;

import java.util.List;
import java.util.Scanner;

public class AccountController {
    static AccountServiceImpl accountService;

    public AccountController() {
        this.accountService = AccountServiceImpl.getInstance();
    }

    public static Messenger createAccount(Scanner sc) {
        return accountService.save(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()

        );
    }

    public static String deposit(Scanner sc) {
        return accountService.deposit(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public static String withdraw(Scanner sc) {
        return accountService.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public static String getBalance(Scanner sc) {
        return accountService.getBalance(sc.next());
    }
    public static Messenger deleteAccount(Scanner sc) {
        return accountService.delete(Account.builder().accountNumber(sc.next()).build());
    }

    public static List<?> getAccounts() {
        return accountService.findAll();
    }
}