package org.example.service.impl;

import org.example.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void withdraw(String account, int amount) {
        if (amount > 100) {
            throw new IllegalArgumentException("Amount too large");
        }

        System.out.println("ACCOUNT :" + account + " withdraw : " + amount);
    }

    @Override
    public int getBalance(int balance) {
        return balance;
    }
}
