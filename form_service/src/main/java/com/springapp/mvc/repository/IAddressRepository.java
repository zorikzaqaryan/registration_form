package com.springapp.mvc.repository;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;

public interface IAddressRepository {

    void addAddress(User user, Address address) throws DatabaseException;

    void removeAddress(User user);

    void editAddress(Address address);

}
