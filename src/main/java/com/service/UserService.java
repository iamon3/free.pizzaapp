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

    @Autowired
    UserHttpClient userHttpClient;

    public User  addUser(User user){
        User signedUpUser = null;
        try {
            signedUpUser = userHttpClient.createUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return signedUpUser;
    }

    public User  authenticateUser(User user){
        User signedInUser = null;
        try {
            signedInUser = userHttpClient.authenticateUser(user.getEmail(), user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return signedInUser;
    }

    public Transaction saveUserTransaction(String email, String id, Transaction transaction){
        Transaction savedTransaction = null;
        try {
            savedTransaction = userHttpClient.saveUserTransaction(email, id, transaction);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return savedTransaction;
    }

    public List<Transaction> fetchUserTransaction(String email, String userId){
        List<Transaction> userTransactions = null;
        try {
            userTransactions = userHttpClient.getUserTransactions(email, userId);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return userTransactions;
    }
}
