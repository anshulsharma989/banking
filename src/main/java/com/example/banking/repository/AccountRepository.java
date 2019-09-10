package com.example.banking.repository;

import com.example.banking.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Object findAllById(Long accountId);
}
