package com.dennis.api.account;

import com.dennis.api.account.Account;

public interface AccountService {
    String deposit(Account account);
    String withdraw(Account account);
    String getBalance(String accountNumber);
}
