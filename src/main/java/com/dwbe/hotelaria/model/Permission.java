package com.dwbe.hotelaria.model;

import jakarta.persistence.*;
@Entity
@Table(name="permission",schema="hotelreservation")
public class Permission {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int permissionId;
    @Column
    private int permissionRoleId;
    @Column
    private String title;
    @Column
    private String module;
    @Column
    private String description;

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public int getPermissionRoleId() {
        return permissionRoleId;
    }

    public void setPermissionRoleId(int permissionRoleId) {
        this.permissionRoleId = permissionRoleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Permission(String permissionTitle){
        this.title = permissionTitle;
    }

    public Permission(){
    }
}
