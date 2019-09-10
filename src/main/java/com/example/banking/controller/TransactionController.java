package com.example.banking.controller;

import com.example.banking.model.Transaction;
import com.example.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    AccountService accountService;

    @PutMapping("/deposit/{id}")
    public String depositAmount(@PathVariable(value = "id") Long accountId, @RequestBody Transaction transaction){
       accountService.depositAmount(accountId, transaction.getAmount());
        return "Amount deposit successfully";
    }

    @PutMapping("withdraw/{id}")
    public String withdrawAmount(@PathVariable(value = "id") Long accountId, @RequestBody Transaction transaction){
        accountService.withdrawAmount(accountId, transaction.getAmount());
        return "Amount withdraw successfully";
    }

    @PutMapping("transfer/{payerAccId}/to/{receiverAccId}")
    public String transferAmount(@PathVariable(value = "payerAccId") Long payerAccountId, @PathVariable(value = "receiverAccId") Long receiverAccountId, @RequestBody Transaction transaction){
        accountService.withdrawAmount(payerAccountId, transaction.getAmount());
        accountService.depositAmount(receiverAccountId, transaction.getAmount());
        return "Amount transferred successfully";
    }
}
