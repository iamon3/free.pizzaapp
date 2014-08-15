package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.form.User;
/**
 */
@Controller
public class SignUpController {

    @RequestMapping("/signUp")
    public String getSignUpForm(){
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method=RequestMethod.POST)
    public String addUser(User user, BindingResult result){
        return "signIn";
    }
}
