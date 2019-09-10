package com.example.banking.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long balance;

    @OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinColumn
    private Customer customer;

    public Account(){}

    public Account(Long id) {
        this.id = id;
    }

    public void setBalance(Long balance){
        this.balance = balance;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Long getBalance(){
        return this.balance;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Long getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    public Map<String, String> getFormattedAccount(){
        Map<String, String> accountMap = new HashMap<>();
        accountMap.put("accountId", getId().toString());
        accountMap.put("balance", getBalance().toString());
        return accountMap;
    }
}
