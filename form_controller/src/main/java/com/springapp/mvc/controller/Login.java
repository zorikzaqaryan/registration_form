package com.springapp.mvc.controller;

import com.springapp.mvc.controller.validator.RegistrationValidator;
import com.springapp.mvc.model.User;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;


@Controller
public class Login {

    @Autowired
    @Qualifier("loginValidator")
    private Validator validator;

    @Autowired
    private UserManager manager;

    @Autowired
    HttpSession session;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView goToLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/loginServlet", method = RequestMethod.POST)
    public String checkUser(Model model, @Validated User user, BindingResult bindingResult) {
        String path = "redirect:userHome";
        boolean isValid = true;

        if (bindingResult.hasErrors()) {
            isValid = false;
        }else if (!manager.isExistingUser(user)) {
            isValid = false;
        }

        if (isValid) {

            User currentUser = manager.findUserByEmailLazy(user);
            session.setAttribute("currentUser", currentUser);

        } else {
            path = "login";
        }
        model.addAttribute("user", user);
        return path;
    }





    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView initUserPage(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
}