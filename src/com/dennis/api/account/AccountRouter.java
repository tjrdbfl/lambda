package com.dennis.api.account;

import com.dennis.api.enums.AccountNavigation;

import java.util.Scanner;

public class AccountRouter {
    public static void main(Scanner sc) {
        AccountController accountController = new AccountController();

        do{
            System.out.println("[Account] 0-Exit 1-Create 2-Deposit " +
                    "3-Withdraw 4-Balance 5-Remove 6-Account List");
        } while (AccountNavigation.accountMenu(sc.next(),sc));

    }
}
