package com.service;

import java.io.IOException;
import java.util.List;

import com.form.User;
import com.form.Transaction;
import com.util.clients.UserHttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class UserService {

    public User  addUser(User user){
        UserHttpClient userHttpClient = new UserHttpClient();
        User signedUpUser = null;
        try {
            signedUpUser = userHttpClient.createUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return signedUpUser;
    }

    public User  authenticateUser(User user){

        UserHttpClient userHttpClient = new UserHttpClient();
        User signedInUser = null;
        try {
            signedInUser = userHttpClient.authenticateUser(user.getEmail(), user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return signedInUser;
    }

    public Transaction saveUserTransaction(String email, String id, Transaction transaction){
        UserHttpClient userHttpClient = new UserHttpClient();
        Transaction savedTransaction = null;
        try {
            savedTransaction = userHttpClient.saveUserTransaction(email, id, transaction);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return savedTransaction;
    }

    public List<Transaction> fetchUserTransaction(String email, String id, Transaction transaction){
        UserHttpClient userHttpClient = new UserHttpClient();
        List<Transaction> userTransactions = null;
        try {
            userTransactions = userHttpClient.getUserTransactions(email, id);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return userTransactions;
    }
}
