package com.springapp.mvc.service;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;

import java.util.List;

public interface IAddressManager {

    void addAddress(Address address) throws DatabaseException;

    void removeAddress(Address address);

    void editAddress(Address address);
}
