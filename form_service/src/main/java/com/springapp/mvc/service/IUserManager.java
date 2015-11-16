package com.springapp.mvc.service;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.User;
import java.util.List;

public interface IUserManager {

    void addUser(User user) throws DatabaseException;

    void removeUser(User user);

    User findUserByEmail(User user);

    List<User> getAllUser();

    void editUser( User user);

    boolean isExistingUser(User user);

    User findUserByEmailLazy(User user);
}
