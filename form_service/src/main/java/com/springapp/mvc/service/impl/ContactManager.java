package com.springapp.mvc.service.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IContactRepository;
import com.springapp.mvc.repository.impl.ContactRepository;
import com.springapp.mvc.service.IContactManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactManager implements IContactManager {

    @Autowired
    IContactRepository repository;

    @Override
    public void addContact(Contact contact) throws DatabaseException {
        repository.addContact(contact);
    }

    @Override
    public void removeContact(Contact contact) {

    }

    @Override
    public void editContact(Contact contact) {

    }
}
