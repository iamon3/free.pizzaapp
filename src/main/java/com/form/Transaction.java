package com.form;

import java.util.ArrayList;
import java.util.List;
import com.form.Pizza;

/**
 */
public class Transaction {
    private String id;
    private String userId;
    private String timestamp;
    private List<Pizza> pizzas = new ArrayList<Pizza>();
    private Integer price = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
        this.price += pizza.getPrice();
    }
}
