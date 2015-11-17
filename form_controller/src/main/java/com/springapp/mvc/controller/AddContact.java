package com.springapp.mvc.controller;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.impl.ContactManager;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "addContact")
public class AddContact {

    @Autowired
    UserManager userManager;

    @Autowired
    ContactManager contactManager;

    @Autowired
    HttpSession session;

    @RequestMapping(method = RequestMethod.GET)
    private String initContactForm(Model model, User user) {
        model.addAttribute("user", user);
        return "addContact";
    }

    @RequestMapping(method = RequestMethod.POST)
    private String addContactToUser(@RequestParam(value = "mobileNumber") String mobileNumber,
                                    @RequestParam(value = "homeNumber") String homeNumber) throws DatabaseException {
        String path = "userHome";
        User sessionUser = (User) session.getAttribute("currentUser");
        if (StringUtils.isEmpty(mobileNumber) && StringUtils.isEmpty(homeNumber)) {
            path = "addContact";
        } else {
            Contact contact = new Contact();
            contact.setHomeNumber(homeNumber);
            contact.setMobileNumber(mobileNumber);
            try {
                contact.setUser(sessionUser);
                contactManager.addContact(contact);
            } catch (DatabaseException e) {
                throw new DatabaseException("", e);
            }
        }
        return "redirect:" + path;
    }
}
