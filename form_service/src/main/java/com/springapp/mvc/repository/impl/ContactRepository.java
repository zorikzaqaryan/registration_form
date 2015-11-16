package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IContactRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class ContactRepository extends BaseRepository implements IContactRepository{

    @Override
    public void addContact(User user, Contact contact) throws DatabaseException {
        try {
            List<Contact> contactList = user.getContact();
            if (contactList == null) {
                contactList = new LinkedList<>();
            }
            contactList.add(contact);
            contact.setUser(user);
            Session session = sessionFactory.getCurrentSession();
            if (session == null) {
                session = sessionFactory.openSession();
            }
            session.save(contact);
            session.flush();
        } catch (Exception e) {
            throw  new DatabaseException("Cant add contact to user");
        }

    }

    @Override
    public void removeContact(User user) {

    }

    @Override
    public List<User> getAllContact() {
        return null;
    }

    @Override
    public void editContact(User user) {

    }
}
