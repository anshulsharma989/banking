package com.example.banking.controller;

import com.example.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

    @Autowired
    AccountService accountService;

    //Get all account
    @GetMapping("/account")
    public List<Map<String, String>> getAllAccount(){
        return accountService.getAllAccounts();
    }

    //Get customer by id
    @GetMapping("/account/{id}")
    public Map<String, String> getAccountById(@PathVariable(value = "id") Long accountId){
        return accountService.getAccountById(accountId);
    }
}
