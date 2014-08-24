package com.util.clients;

import com.form.Pizza;
import com.form.Topping;
import com.form.Transaction;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 */
@Component
public class TransactionParser {

    public Transaction bindToTransaction(Map<String, String[]> parameterMap){

        Transaction transaction = new Transaction();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        transaction.setTimestamp(dateFormat.format(cal.getTime()));
        boolean isTransaction = false;

        Iterator iter = parameterMap.entrySet().iterator();
        System.out.print("<<<<<<< Parameter Map >>>>>>>>");
        while ( iter.hasNext() )
        {
            Map.Entry entry  = (Map.Entry)iter.next() ;
            String    name   = (String)entry.getKey() ;
            String[]  values = (String[])entry.getValue();
            System.out.println("Name:   " + name + " Values : " + values + "\n");
            if(name.equals(values[0])){
                if(isTransaction == false) { isTransaction = true;}
                Pizza pizza = new Pizza();
                pizza.setId(name);
                String[] tokens;
                if(1 < values.length){
                    tokens =  values[1].split("#");
                    pizza.setId(tokens[0]);
                    pizza.setName(tokens[1]);
                    pizza.setPrice(Integer.valueOf(tokens[2]));
                    pizza.setDescription(tokens[6]);
                }
                for ( int i = 1; i < values.length ; ++i )
                {
                    // id#name#price#id#name#price#pizza description
                    tokens = values[i].split("#");

                    Topping topping = new Topping();
                    topping.setId(tokens[3]);
                    topping.setName(tokens[4]);
                    topping.setPrice(Integer.valueOf(tokens[5]));
                    pizza.addTopping(topping);
                }
                transaction.addPizza(pizza);
            }
        }
        if(isTransaction) {return transaction;}
        System.out.print("<<<<<<< Parameter Map >>>>>>>>");
        return null;
    }
}
