package com.dennis.api.account;

import com.dennis.api.enums.AccountNavigationOfPredicate;

import java.util.Scanner;

public class AccountRouter {
    public static void main(Scanner sc) {
        AccountController accountController = new AccountController();
        while (AccountNavigationOfPredicate.accountMenu(sc));

    }
}
