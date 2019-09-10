package com.example.banking.service;

import com.example.banking.model.Account;
import com.example.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Map<String, String>> getAllAccounts(){
        List<Map<String, String>> accountList = new ArrayList<>();
        for(Account account :accountRepository.findAll()){
            accountList.add(account.getFormattedAccount());
        }
        return accountList;
    }

    public Map<String, String> getAccountById(Long accountId){
        return accountRepository.findById(accountId).get().getFormattedAccount();
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    public boolean deleteAccount(Long accountId){
        accountRepository.delete(new Account(accountId));
        return true;
    }

    public Account depositAmount(Long accountId, Long amount){
        Account account = accountRepository.findById(accountId).get();
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }


    public Account withdrawAmount(Long accountId, Long amount){
        Account account = accountRepository.findById(accountId).get();
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }
}
