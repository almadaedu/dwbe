package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> database = new ArrayList<>();

    public void addUser(User user){
        database.add(user);
    }

    public void editUser(User user) {
        int index = database.indexOf(user);
        if(index > 0){
            database.set(index, user);
        }
    }

    public User searchUser(String userName){
        int index = database.indexOf(new User(userName));
        if(index < 0){
            return new User();
        }
        User selectUser = database.get(index);
        return selectUser;
    }

    public List<User> userList(){
        return database;
    }
}
