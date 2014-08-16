package com.service;

import java.io.IOException;
import com.form.User;
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
}
