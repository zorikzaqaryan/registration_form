package com.springapp.mvc.controller;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springapp.mvc.model.User;

@Controller
public class Registration {

    @Autowired
    @Qualifier("registrationValidator")
    private Validator validator;

    @Autowired
    UserManager manager;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/checkRegistration", method = RequestMethod.POST)
    public String checkForm(Model model,
                            @Validated User user,
                            BindingResult bindingResult) throws DatabaseException {
        String path = "registration";

        if (!bindingResult.hasErrors()) {
            path = "login";
            manager.addUser(user);
        }
        model.addAttribute("user", user);
        return path;
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String initForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }


}