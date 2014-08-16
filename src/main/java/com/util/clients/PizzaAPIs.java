package com.util;

import java.net.URI;
import org.apache.http.client.utils.URIBuilder;

/**
 */
public abstract class PizzaAPIs {

    public static String URI_SCHEME_HTTP = "http";
    public static String API_END_POINT = "http://localhost:9090/freeapis";
    public static String API_SERVER_HOST_END_POINT = "localhost:9090/freeapis";
    public static String PIZZAS_RESOURCE = "/pizzas";
    public static String USERS_RESOURCE = "/users";
    public static String TOPPINGS_RESOURCE = "/toppings";
    public static String USER_AUTHENTICATE_RESOURCE = "/authenticate";

    public static final String HTTP_HEADER_ACCEPT = "Accept";
    public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    public static final String MEDIA_TYPE_APPLICATION_JSON = "application/json";

    public static final int HTTP_STATUS_OK = 200;
    public static final int HTTP_STATUS_UNAUTHORIZED = 401;
    public static final int HTTP_STATUS_FORBIDDEN = 403;
    public static final int HTTP_STATUS_RESOURCE_NOT_FOUND = 404;
    public static final int HTTP_STATUS_INTERNAL_SERVER_ERROR = 500;

    private static final String URL_PATH_SEPARATOR = "/";
    private static final String QUERY_PARAM_SEPARATOR = "&";
    private static final String URI_QUERY_PARAM_SEPARATOR = "?";
    private static final String PARAM_VALUE_SEPARATOR = "=";

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static URI getAddUserApi(){
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme(URI_SCHEME_HTTP)
                    .setHost(API_SERVER_HOST_END_POINT)
                    .setPath(USERS_RESOURCE).build();
        }
        catch (java.net.URISyntaxException ue){
            ue.printStackTrace();
        }
        return uri;
    }

    public static URI getAuthenticateUserApi(String email, String password){
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme(URI_SCHEME_HTTP)
                    .setHost(API_SERVER_HOST_END_POINT)
                    .setPath(USERS_RESOURCE + USER_AUTHENTICATE_RESOURCE)
                    .setParameter(EMAIL, email)
                    .setParameter(PASSWORD, password).build();


        }
        catch (java.net.URISyntaxException ue){
            ue.printStackTrace();
        }
        return uri;
    }
}
