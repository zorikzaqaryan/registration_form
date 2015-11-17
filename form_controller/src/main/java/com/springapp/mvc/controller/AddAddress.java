package com.springapp.mvc.controller;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;

import com.springapp.mvc.model.convertor.UserConverter;
import com.springapp.mvc.model.dto.LazyUser;
import com.springapp.mvc.service.impl.AddressManager;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.springapp.mvc.model.convertor.UserConverter.lazyUserToUser;

@Controller
@RequestMapping(value = "addAddress")
public class AddAddress {
    @RequestMapping(method = RequestMethod.GET)
    private String initContactForm(Model model, User user) {
        model.addAttribute("user", user);
        return "addAddress";
    }

    @Autowired
    UserManager userManager;

    @Autowired
    AddressManager addressManager;


    @Autowired
    HttpServletRequest request;


    @RequestMapping(method = RequestMethod.POST)
    private String addContactToUser(@RequestParam(value = "city") String city,
                                    @RequestParam(value = "street") String street) throws DatabaseException {
        String path = "userHome";
        LazyUser currentUser = (LazyUser) request.getSession().getAttribute("currentUser");
        User user = lazyUserToUser(currentUser);
        if (StringUtils.isEmpty(city) && StringUtils.isEmpty(street)) {
            path = "addAddress";
        } else {
            Address address = new Address();
            address.setCity(city);
            address.setStreet(street);
            try {
//                user.getAddress().add(address);
                address.setUser(user);
                addressManager.addAddress(address);
            } catch (DatabaseException e) {
                throw  new DatabaseException(e);
            }
        }
        return "redirect:" + path;
    }


}
