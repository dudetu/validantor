package org.example.services;

import org.example.entity.Account;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {


    void transfer (long id1, long id2, double amount);
}
