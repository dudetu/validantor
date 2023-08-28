package org.example.services;

import org.example.entity.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        try{
            return userRepository.getReferenceById(id);
        }catch (Exception e){
            throw new IllegalArgumentException("User with id " + id + " not found");
        }

    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
