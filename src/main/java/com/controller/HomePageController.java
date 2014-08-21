package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import com.service.UserService;

import com.form.User;

import java.util.Map;

/**
 */
@Controller
public class HomePageController {

    @Autowired
    UserService userService;

    @RequestMapping("/homePage")
    public String getSignInForm(HttpServletRequest httpServletRequest, Map<String, Object> map){
        String email = (String) httpServletRequest.getSession().getAttribute("email");
        String id = (String) httpServletRequest.getSession().getAttribute("id");
        map.put("email", httpServletRequest.getSession().getAttribute("email"));
        return "homePage";
    }
}
