package org.example.services;

import org.example.entity.User;

import java.util.List;


public interface UserService {

    public List<User> getAll();

    User getById(long id);


    public User addUser(User user);
}
