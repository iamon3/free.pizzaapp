package com.controller;

import com.exceptions.ResourceNotFoundException;
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
public class SignInController {

    @Autowired
    UserService userService;

    @RequestMapping("/signIn")
    public String getSignInForm(Map<String, Object> map){
        map.put("user", new User());
        return "signIn";
    }

    @RequestMapping(value = "/signIn", method=RequestMethod.POST)
    public String signInUser(HttpServletRequest httpServletRequest, Map<String, Object> map, @ModelAttribute("user") User user, BindingResult result){
        User authenticatedUser = null;
        try {
            authenticatedUser = userService.authenticateUser(user);
            //map.put("email", authenticatedUser.getEmail());
            httpServletRequest.getSession().setAttribute("email", authenticatedUser.getEmail());
            httpServletRequest.getSession().setAttribute("id", authenticatedUser.getId());

        }
        catch (ResourceNotFoundException re){
            map.put("notFound", re.toString());
            return "signIn";
        }
        return "redirect:/homePage";
    }
}
