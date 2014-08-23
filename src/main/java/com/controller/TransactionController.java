package com.controller;

import com.form.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import com.service.UserService;

import java.util.List;
import java.util.Map;
import com.util.PizzaAPIs;

/**
 */
@Controller
public class TransactionController {

    @Autowired
    UserService userService;

    @Autowired
    PizzaAPIs pizzaAPIs;

    // TODO Add the correct return result page. Also check if the RequestMapping can contain path parameters
    @RequestMapping("/transactions")
    public String getUserTransactions(HttpServletRequest httpServletRequest, Map<String, Object> map, BindingResult result){
        String email = (String) httpServletRequest.getSession().getAttribute("email");
        String id = (String) httpServletRequest.getSession().getAttribute("id");
        List<Transaction> transactionList = userService.fetchUserTransaction(email,id);
        map.put("transactions", transactionList);
        map.put("pizzasAPI",pizzaAPIs.getPizzasApi());
        map.put("toppingsAPI",pizzaAPIs.getToppingsApi());
        return "transactions";
    }
}
