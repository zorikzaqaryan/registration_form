package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IAddressRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
@Repository
@org.springframework.transaction.annotation.Transactional
public class AddressRepository extends BaseRepository implements IAddressRepository  {

    @Override
    public void addAddress(Address address) throws DatabaseException {
        try {

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
