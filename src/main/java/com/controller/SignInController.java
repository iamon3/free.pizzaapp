package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.form.User;

import java.util.Map;

/**
 */
@Controller
public class SignInController {
    @RequestMapping("/signIn")
    public String getSignInForm(Map<String, Object> map){
        map.put("user", new User());
        return "signIn";
    }

    @RequestMapping(value = "/signIn", method=RequestMethod.POST)
    public String signInUser(@ModelAttribute("user") User user, BindingResult result){
        return "homePage";
    }

}
