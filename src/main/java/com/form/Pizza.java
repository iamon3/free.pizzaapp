package com.form;

import java.util.ArrayList;
import java.util.List;

import com.form.Topping;
/**
 */
public class Pizza {

    private String id;
    private String name;
    private String description;
    List<Topping> toppings;
    private Integer price;

    public Pizza(){

    }

    public Pizza(String id, String name, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.toppings= new ArrayList<Topping>();
    }

    public void addTopping(Topping topping){
        this.price += Integer.parseInt(topping.getPrice());
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

