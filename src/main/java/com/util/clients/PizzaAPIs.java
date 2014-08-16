package com.util;

/**
 */
public abstract class PizzaAPIs {
    private static String API_END_POINT = "http://localhost:9090/freeapis";
    private static String PIZZAS_RESOURCE = "/pizzas";
    private static String USERS_RESOURCE = "/users";
    private static String TOPPINGS_RESOURCE = "/toppings";
    private static String USER_AUTHENTICATE_RESOURCE = "/authenticate";

    public static final String HTTP_HEADER_ACCEPT = "Accept";
    public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    public static final String MEDIA_TYPE_APPLICATION_JSON = "application/json";


    public static String getAddUserApi(){
        return API_END_POINT + USERS_RESOURCE;
    }

    public static String getAuthenticateUserApi(){
        return  API_END_POINT + USERS_RESOURCE + USER_AUTHENTICATE_RESOURCE;
    }
}
