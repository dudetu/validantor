package org.example.services;

import org.example.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    AccountService accountService;

    @Override
    public void transfer(long id1, long id2, double amount) {
        Account accountOne = accountService.getById(id1);
        if (accountOne.getAmount() - amount < 0){
            throw new IllegalArgumentException("Not enough amount on account one");
    }
        accountOne.setAmount(accountOne.getAmount() - amount);
        accountService.saveAccount(accountOne);

        Account accountTwo = accountService.getById(id2);
        accountTwo.setAmount(accountOne.getAmount() + amount);
        accountService.saveAccount(accountTwo);

    }
}
