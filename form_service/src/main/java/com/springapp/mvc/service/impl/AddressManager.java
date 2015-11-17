package com.springapp.mvc.service.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.repository.IAddressRepository;
import com.springapp.mvc.service.IAddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressManager implements IAddressManager {

    @Autowired
    private IAddressRepository repository;

    @Override
    public void addAddress(Address address) throws DatabaseException {
        try {
            repository.addAddress(address);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void removeAddress(Address address) {

    }

    @Override
    public void editAddress(Address address) {

    }
}
