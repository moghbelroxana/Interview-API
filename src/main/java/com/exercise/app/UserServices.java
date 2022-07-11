package com.exercise.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UserServices {

    //Create list of users and example user
    List<User> users=new ArrayList<>(Arrays.asList(
        new User(UUID.randomUUID(), "josh1", "Passw0rd.", "100.42.255.255", "Halifax")
    ));

    //return list of users
    public List<User> getAllUsers() {
        return users;
    }

    //Get specific user from list (Not required)
    // public User getUser(String id){
    //     return users.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    // }

    //add user to collection of users
    public void addUserToList(User user) {
        users.add(user);
    }
}
