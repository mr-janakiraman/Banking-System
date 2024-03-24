package com.janakiraman.AarushBank.service;

import com.janakiraman.AarushBank.dto.Account;
import com.janakiraman.AarushBank.dto.Client;
import com.janakiraman.AarushBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account findAccount(int number) {
        return accountRepository.getAccount(number);
    }

    public String addAccount(Account account) {
        return accountRepository.addAccount(account);
    }

    public String deleteAccount(int number) {
        return accountRepository.delAccount(number);
    }

    public String creditAccount(Account account) {

        float currbalance = findAccount(account.getNumber()).getBalance();
        account.setBalance(account.getBalance()+currbalance);
        return accountRepository.creditAccount(account);
    }

    public String debitAccount(Account account) {
        float currbalance = findAccount(account.getNumber()).getBalance();
        account.setBalance(currbalance-account.getBalance());


        return (account.getBalance()>0) ? accountRepository.debitAccount(account) : "Not enough amount";
    }
}
