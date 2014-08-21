package com.form;


/**
 */
public class Topping {

    private String id;
    private String name;
    private Integer price;

    public Topping(String id, String name, Integer price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Topping(){

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
