package com.springapp.mvc.model.convertor;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.dto.LazyUser;


public class UserConverter {

    public static User lazyUserToUser(LazyUser lazyUser) {
        User user = new User();
        user.setId(lazyUser.getId());
        user.setName(lazyUser.getName());
        user.setSurname(lazyUser.getSurname());
        user.setEmail(lazyUser.getEmail());
        user.setPassword(lazyUser.getPassword());
        return user;
    }
}
