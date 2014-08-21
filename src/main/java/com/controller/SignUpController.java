package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import com.service.UserService;

import com.form.User;

import java.io.IOException;
import java.util.Map;

/**
 */
@Controller
public class SignUpController {

    @Autowired
    UserService userService;

    @RequestMapping("/signUp")
    public String getSignUpForm(Map<String, Object> map){
        map.put("user", new User());
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method=RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result){
        userService.addUser(user);
        return "redirect:/signIn";
    }
}
