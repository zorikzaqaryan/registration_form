package com.springapp.mvc.util_test;

import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class UserUtilTest {

    public  static User getCustomUser(){
        User user =  new User();
        user.setName("name");
        user.setSurname("surname");
        user.setEmail("email");
        user.setPassword("password");
        user.setConfirmPassword("password");
        user.setOnline(false);
        Address address =  new Address();
        address.setCity("city");
        address.setStreet("street");
        user.setAddress(Collections.singletonList(address));
        Contact contact = new Contact();
        contact.setHomeNumber("1234");
        contact.setMobileNumber("12321");
        user.setContact(Collections.singletonList(contact));

        return user;
    }

    public static List<User> getUserList(){
        List<User> userList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            userList.add(getCustomUser());
        }
        return userList;
    }
}
