package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleService {

    private List<Role> database = new ArrayList<>();

    public void addRole(Role role){
        database.add(role);
    }

    public void editRole(Role role) {
        int index = database.indexOf(role);
        if(index > 0){
            database.set(index, role);
        }
    }

    public Role searchRole(String roleTitle){
        int index = database.indexOf(new Role(roleTitle));
        if(index < 0){
            return new Role();
        }
        Role selectRole = database.get(index);
        return selectRole;
    }

    public List<Role> roleList(){
        return database;
    }
}
