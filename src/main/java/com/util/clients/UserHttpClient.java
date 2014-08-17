package com.util.clients;

import java.net.URI;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.TypeReference;

import com.form.User;
import com.form.Transaction;

import com.util.PizzaAPIs;
import static com.util.PizzaAPIs.HTTP_HEADER_ACCEPT;
import static com.util.PizzaAPIs.HTTP_HEADER_CONTENT_TYPE;
import static com.util.PizzaAPIs.MEDIA_TYPE_APPLICATION_JSON;
import static com.util.PizzaAPIs.*;

/**
 */
public class UserHttpClient {

    public User createUser(User user) throws IOException {
        User signedUpUser = null;
        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(getAddUserApi());

            // Add HTTP headers to HTTP request
            httpPost.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);
            httpPost.addHeader(HTTP_HEADER_CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);

            // Create JSON body required by POST document API call
            JSONObject jsonBody = new JSONObject();
            String userJson ="";
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            userJson = ow.writeValueAsString(user);
            System.out.println("User json : " + userJson);

            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(IOUtils.toInputStream(userJson));
            httpPost.setEntity(basicHttpEntity);

            // Make a POST HTTP call
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            InputStream responseStream = entity.getContent();
            if (responseStream != null) {
                responseContent = IOUtils.toString(responseStream);
                System.out.println("Response Content : " + responseContent);
            }
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }

            System.out.println("Response Status: " + response.getStatusLine());
            if(HTTP_STATUS_OK == response.getStatusLine().getStatusCode()){
                if(null != responseContent && "" != responseContent.trim()){
                    signedUpUser = new ObjectMapper().readValue(responseStream, User.class);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return signedUpUser;
    }

    public User authenticateUser(String email, String password) throws IOException {
        User authenticatedUser = null;
        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpGet httpGet = new HttpGet(getAuthenticateUserApi(email, password));

            // Add HTTP headers to HTTP request
            httpGet.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);

            // Make a POST HTTP call
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream responseStream = entity.getContent();
            //if (responseStream != null) {
              //  responseContent = IOUtils.toString(responseStream);
                //System.out.println("Response Content : " + responseContent);
            //}
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }

            System.out.println("Response Status: " + response.getStatusLine());
            if(HTTP_STATUS_OK == response.getStatusLine().getStatusCode()){
                if(null != responseStream){
                    authenticatedUser = new ObjectMapper().readValue(responseStream, User.class);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return authenticatedUser;
    }

    public Transaction saveUserTransaction(String email, String id, Transaction transaction) throws IOException {
        Transaction savedTransaction = null;
        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(getUserTransactionsApi(email, id));

            // Add HTTP headers to HTTP request
            httpPost.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);
            httpPost.addHeader(HTTP_HEADER_CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);

            // Create JSON body required by POST document API call
            JSONObject jsonBody = new JSONObject();
            String transactionJson ="";
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            transactionJson = ow.writeValueAsString(transaction);
            System.out.println("Transaction json : " + transactionJson);

            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(IOUtils.toInputStream(transactionJson));
            httpPost.setEntity(basicHttpEntity);

            // Make a POST HTTP call
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            InputStream responseStream = entity.getContent();
            if (responseStream != null) {
                responseContent = IOUtils.toString(responseStream);
                System.out.println("Response Content : " + responseContent);
            }
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }

            System.out.println("Response Status: " + response.getStatusLine());
            if(HTTP_STATUS_OK == response.getStatusLine().getStatusCode()){
                if(null != responseContent && "" != responseContent.trim()){
                    savedTransaction = new ObjectMapper().readValue(responseStream, Transaction.class);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return savedTransaction;
    }

    public List<Transaction> getUserTransactions(String email, String id) throws IOException {
        List<Transaction> userTransactions = null;
        String responseContent = "";
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;

        try {
            HttpGet httpGet = new HttpGet(getUserTransactionsApi(email, id));

            // Add HTTP headers to HTTP request
            httpGet.addHeader(HTTP_HEADER_ACCEPT, MEDIA_TYPE_APPLICATION_JSON);

            // Make a POST HTTP call
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream responseStream = entity.getContent();
            //if (responseStream != null) {
            //  responseContent = IOUtils.toString(responseStream);
            //System.out.println("Response Content : " + responseContent);
            //}
            if (entity != null) {
                System.out.println("Response entity : " + entity);
            }

            System.out.println("Response Status: " + response.getStatusLine());
            if(HTTP_STATUS_OK == response.getStatusLine().getStatusCode()){
                if(null != responseStream){
                    userTransactions = new ObjectMapper().readValue(responseStream, new TypeReference<List<Transaction>>(){});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }
        return userTransactions;
    }

    /**
     * Returns an instance of Apache's ClosableHttpClient.
     */
    private static CloseableHttpClient getHttpClient(){
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        return closeableHttpClient;
    }
}
