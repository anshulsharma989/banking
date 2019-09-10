package com.example.banking.controller;

import com.example.banking.DTO.CustomerDTO;
import com.example.banking.model.Customer;
import com.example.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //Get all customers
    @GetMapping("/customer")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    //Create customer
    @PostMapping("/customer")
    public Map<String, Object> createCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        return customerService.createCustomer(new Customer(customerDTO.getFirstName(), customerDTO.getLastName()));
    }

    //Get customer by id
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long customerId){
        return customerService.getCustomerById(customerId);
    }

    // Update customer
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") Long customerId,
                               @Valid @RequestBody CustomerDTO customerDetails) {
        return customerService.updateCustomer(customerId, customerDetails);
    }

    // Delete customer
    @DeleteMapping("/customer/{id}")
    public boolean deleteCustomer(@PathVariable(value = "id") Long customerId) {
        return customerService.deleteCustomer(customerId);
    }
}
