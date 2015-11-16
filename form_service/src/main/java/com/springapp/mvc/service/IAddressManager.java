package com.springapp.mvc.service;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;

import java.util.List;

public interface IAddressManager {

    void addAddress(User user, Address address) throws DatabaseException;

    void removeAddress(User user);

    void editAddress(Address address);
}
