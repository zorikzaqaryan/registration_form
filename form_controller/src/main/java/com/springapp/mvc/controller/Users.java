package com.springapp.mvc.controller;

import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Users {

    @Autowired
    UserManager manager;

    @RequestMapping(value = "userHome",method = {RequestMethod.POST,RequestMethod.GET})

    private String getUsers(Model model) {
        List userList = manager.getAllUser();
        model.addAttribute("users", userList);
        return "user";
    }


}
