package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IAddressRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class AddressRepository extends BaseRepository implements IAddressRepository  {



    @Override
    public void addAddress(User user, Address address) throws DatabaseException {  //remove user
        try {
            List<Address> addressList = user.getAddress();
            if (addressList == null) {
                addressList = new LinkedList<>();
            }

            addressList.add(address);
            address.setUser(user);
            Session session = sessionFactory.getCurrentSession();
            if (session == null) {
                session = sessionFactory.openSession();
            }
            session.save(address);
            session.flush();
        } catch (Exception e) {
           throw  new DatabaseException("Cant add Address to user");
        }

    }

    @Override
    public void removeAddress(User user) {

    }

    @Override
    public void editAddress(Address address) {

    }
}
