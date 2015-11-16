package com.springapp.mvc.service;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;

public interface IContactManager {

    void addContact(User user, Contact contact) throws DatabaseException;

    void removeContact(User user);

    void editContact(Contact contact);
}
