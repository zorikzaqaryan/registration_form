package com.springapp.mvc.service.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IUserRepository;
import com.springapp.mvc.service.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserManager {

    @Autowired
    private IUserRepository repository;

    @Override
    public void addUser(User user) throws DatabaseException {
        repository.addUser(user);
    }

    @Override
    public void removeUser(User user) {
        repository.removeUser(user);
    }

    @Override
    public User findUserByEmail(User user) {
        return repository.findUserByEmail(user);
    }

    @Override
    public List<User> getAllUser() {
        return repository.getAllUser();
    }

    @Override
    public void editUser(User user) {
        repository.editUser(user);
    }

    @Override
    public boolean isExistingUser(User user) {
        return repository.isExistingUser(user);
    }

    @Override
    public User findUserByEmailLazy(User user) {
        return repository.findUserByEmailLazy(user);
    }


}
