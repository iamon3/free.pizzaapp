package com.controller;

import com.form.Transaction;
import com.util.clients.TransactionParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import com.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
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
    TransactionParser transactionParser;

    @Autowired
    PizzaAPIs pizzaAPIs;

    // TODO Add the correct return result page. Also check if the RequestMapping can contain path parameters
    @RequestMapping("/transactions")
    public String getUserTransactions(HttpServletRequest httpServletRequest, Map<String, Object> map){
        String email = (String) httpServletRequest.getSession().getAttribute("email");
        String id = (String) httpServletRequest.getSession().getAttribute("id");
        List<Transaction> transactionList = userService.fetchUserTransaction(email,id);
        map.put("transactions", transactionList);
        map.put("pizzasAPI",pizzaAPIs.getPizzasApi());
        map.put("toppingsAPI",pizzaAPIs.getToppingsApi());
        return "transactions";
    }

    @RequestMapping(value="/transactions", method=RequestMethod.POST)
    public String saveUserTransactions(HttpServletRequest httpServletRequest, Map<String, Object> map){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        String email = (String) httpServletRequest.getSession().getAttribute("email");
        String id = (String) httpServletRequest.getSession().getAttribute("id");
        displayParameterMap(parameterMap);
        Transaction transaction = transactionParser.bindToTransaction(parameterMap);
        if(null == transaction){
            return "redirect:/homePage";
        }
        userService.saveUserTransaction(email,id, transaction);
        return "redirect:/transactions";
    }

    private void displayParameterMap(Map<String, String[]> map){
        Iterator iter = map.entrySet().iterator();
        System.out.print("<<<<<<< Parameter Map >>>>>>>>");
        while ( iter.hasNext() )
        {
            Map.Entry entry  = (Map.Entry)iter.next() ;
            String    name   = (String)entry.getKey() ;
            String[]  values = (String[])entry.getValue();
            System.out.println("Name:   "+name + " Values : ");
            for ( int i = 0 ; i < values.length ; ++i )
            {
                System.out.print("Values[" + i + "]:" + values[i] + ", ");
            }
            System.out.print("\n");
        }
        System.out.print("<<<<<<< Parameter Map >>>>>>>>");
    }

    private String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }
}
