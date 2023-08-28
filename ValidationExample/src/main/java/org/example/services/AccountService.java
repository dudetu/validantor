package org.example.services;

import org.example.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();

    Account saveAccount(Account account);

    Account getById(long id);

}
