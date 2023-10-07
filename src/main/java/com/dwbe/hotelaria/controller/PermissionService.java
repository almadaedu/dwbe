package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Permission;

import java.util.ArrayList;
import java.util.List;

public class PermissionService {

    private List<Permission> database = new ArrayList<>();

    public void addPermission(Permission hotel){
        database.add(hotel);
    }

    public void editPermission(Permission hotel) {
        int index = database.indexOf(hotel);
        if(index > 0){
            database.set(index, hotel);
        }
    }

    public Permission searchPermission(String permissionTitle){
        int index = database.indexOf(new Permission(permissionTitle));
        if(index < 0){
            return new Permission();
        }
        Permission selectPermission = database.get(index);
        return selectPermission;
    }

    public List<Permission> permissionList(){
        return database;
    }
}
