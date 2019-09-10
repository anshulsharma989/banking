package com.example.banking.service;

import com.example.banking.DTO.CustomerDTO;
import com.example.banking.model.Account;
import com.example.banking.model.Customer;
import com.example.banking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountService accountService;

    public List<Customer> getAllCustomer(){
       List<Customer> customerList = new ArrayList<>();
       customerRepository.findAll().forEach( e -> customerList.add(e));
       return  customerList;
    }

    public Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId).get();
    }

    public Map<String, Object> createCustomer(Customer customer){
        customer = customerRepository.save(customer);
        Account account = new Account();
        account.setBalance(10L);
        account.setCustomer(customer);
        accountService.createAccount(account);
        customer.setAccount(account);
        return getFormatedCustomer(customer);
    }

    public Customer updateCustomer(Long customerId, CustomerDTO customerDTO){
        Customer customer = customerRepository.findById(customerId).get();
        if(!customer.getFirstName().equals(customerDTO.getFirstName()))
            customer.setFirstName(customerDTO.getFirstName());
        if(!customer.getLastName().equals(customerDTO.getLastName()))
            customer.setLastName(customerDTO.getLastName());
        return customerRepository.save(customer);
    }

    public boolean deleteCustomer(Long customerId){
        customerRepository.delete(new Customer(customerId));
        return true;
    }

    private Map<String, Object> getFormatedCustomer(Customer customer){
        Map<String, Object> customerMap = new HashMap<>();
        customerMap.put("firstName", customer.getFirstName());
        customerMap.put("LastName", customer.getLastName());
        customerMap.put("account", customer.getAccount().getFormattedAccount());
        return customerMap;
    }
}