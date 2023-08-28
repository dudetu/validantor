package org.example.controller;

import org.example.entity.Account;
import org.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    List<Account> getAll(){
        return accountService.getAll();
    }

    @PostMapping
    ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.saveAccount(account));
    }

    @GetMapping("/{id}")
    Account getById(@PathVariable (name = "id") long id){
        return accountService.getById(id);
    }

}
