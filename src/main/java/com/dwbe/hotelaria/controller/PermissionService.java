package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Permission;

import java.util.ArrayList;
import java.util.List;

public class PermissionService {

    private List<Permission> database = new ArrayList<>();

    public void addPermission(Permission permission){
        database.add(permission);
    }

    public void editPermission(Permission permission) {
        int index = database.indexOf(permission);
        if(index > 0){
            database.set(index, permission);
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
