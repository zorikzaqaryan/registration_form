package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class Logout {
    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String setUserOffline(Model model) {
        session.invalidate();
        model.addAttribute("user", new User());
        return "redirect:login";
    }

}
