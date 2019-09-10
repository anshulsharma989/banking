package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mvcs;

    @MockBean
    private AccountRepository repository;

    @Test
    public void getAllAccountAPI() throws Exception{
        Mockito.when(repository.findAll()).thenReturn(getList());
        mvcs.perform( get("/api/accounts")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("accounts"));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts").exists());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[*].id").isNotEmpty());

//        final AccountController accountController = new AccountController();
//        mvcs = MockMvcBuilders.standaloneSetup(accountController).build();

//        mvcs.perform(get("/api/accounts"))
//                //.andExpect((MockMvcResultMatchers.model()).attribute("categories",ALL_CATEGORIES));
//                .andExpect(MockMvcResultMatchers.view().name("balance"));
    }

    private List<Account> getList(){
        List<Account> accountList = Arrays.asList(
                new Account(120L),
                new Account(120L)
        );
        return accountList;
    }
}
