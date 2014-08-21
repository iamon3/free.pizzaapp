package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;

import com.form.User;

import java.util.Map;

/**
 */
@Controller
public class SignOutController {
    @RequestMapping("/signOut")
    public String signOutUser(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, Map<String, Object> map){


        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");

        /**
        Cookie c = new Cookie("email", "");
        c.setMaxAge(0);
        //if (domain != null)
          //  c.setDomain(domain);
        c.setPath("/");
        httpServletResponse.addCookie(c);
*/
        httpServletRequest.getSession().invalidate();
        map.put("user", new User());
        return "redirect:/signIn";
    }
}
