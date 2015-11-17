package com.springapp.mvc.repository;


import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.dto.LazyUser;

import java.util.List;

public interface IUserRepository {
    void addUser(User user) throws DatabaseException;

    void removeUser(User user);

    User findUserByEmail(User user);

    LazyUser findUserByEmailLazy(User user);

    User getLazyUser(User user);

    List<User> getAllUser();

    void editUser(User user);

    boolean isExistingUser(User user);

}
