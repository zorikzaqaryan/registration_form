package com.springapp.mvc.repository;


import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;

import java.util.List;

public interface IContactRepository {

    void addContact(User user, Contact contact) throws DatabaseException;

    void removeContact(User user);

    List<User> getAllContact();

    void editContact(User user);

}
