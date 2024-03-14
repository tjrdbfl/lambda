package com.dennis.api.account;

import com.dennis.api.enums.Messenger;

import java.util.List;
import java.util.Scanner;

public class AccountController {
    private static AccountController accountController=new AccountController();
    private AccountServiceImpl accountService;
    private AccountController(){
        accountService=AccountServiceImpl.getInstance();
    }

    public static AccountController getInstance(){
        return accountController;
    }


    public Messenger createAccount(Scanner sc) {
        return accountService.save(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()

        );
    }

    public String deposit(Scanner sc) {
        return accountService.deposit(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String withdraw(Scanner sc) {
        return accountService.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String getBalance(Scanner sc) {
        return accountService.getBalance(sc.next());
    }
    public Messenger deleteAccount(Scanner sc) {
        return accountService.delete(Account.builder().accountNumber(sc.next()).build());
    }

    public List<?> getAccounts() {
        return accountService.findAll();
    }
}