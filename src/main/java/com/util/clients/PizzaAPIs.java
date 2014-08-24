package com.util;

import java.net.URI;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/**
 */
@Component("apiServerConfig")
public class PizzaAPIs {

    @Value( "${apiserver.urischeme}" ) private String uriScheme;
    @Value( "${apiserver.endpoint}" )  private String apiServerHost;
    @Value( "${apiserver.baseResource}" )  private String apiServerBaseUrl;
    @Value( "${apiserver.resource.pizzas}" ) private String pizzasResource;
    @Value( "${apiserver.resource.users}" )private String usersResource;
    @Value( "${apiserver.resource.toppings}" ) private String toppingsResource;
    @Value( "${apiserver.resource.transactions}" ) private String transactionsResource;
    @Value( "${apiserver.resource.authenticate}" ) private String authenticateResource;

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

    public URI getAddUserApi(){
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme(uriScheme)
                    .setHost(apiServerHost)
                    .setPath(apiServerBaseUrl + usersResource).build();
        }
        catch (java.net.URISyntaxException ue){
            ue.printStackTrace();
        }
        return uri;
    }

    public URI getAuthenticateUserApi(String email, String password){
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme(uriScheme)
                    .setHost(apiServerHost)
                    .setPath(apiServerBaseUrl + usersResource + authenticateResource)
                    .setParameter(EMAIL, email)
                    .setParameter(PASSWORD, password).build();


        }
        catch (java.net.URISyntaxException ue){
            ue.printStackTrace();
        }
        return uri;
    }

    public URI getUserTransactionsApi(String email, String userId){
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme(uriScheme)
                    .setHost(apiServerHost)
                    .setPath(apiServerBaseUrl + usersResource + URL_PATH_SEPARATOR + userId + transactionsResource)
                    .setParameter(EMAIL, email).build();
        }
        catch (java.net.URISyntaxException ue){
            ue.printStackTrace();
        }
        return uri;
    }

    public URI getPizzasApi(){
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme(uriScheme)
                    .setHost(apiServerHost)
                    .setPath(apiServerBaseUrl + pizzasResource).build();
        }
        catch (java.net.URISyntaxException ue){
            ue.printStackTrace();
        }
        return uri;
    }

    public URI getToppingsApi(){
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme(uriScheme)
                    .setHost(apiServerHost)
                    .setPath(apiServerBaseUrl + toppingsResource).build();
        }
        catch (java.net.URISyntaxException ue){
            ue.printStackTrace();
        }
        return uri;
    }
}
