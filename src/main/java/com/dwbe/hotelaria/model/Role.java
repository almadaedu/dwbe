package com.dwbe.hotelaria.model;

import jakarta.persistence.*;
@Entity
@Table(name="role",schema="hotelreservation")
public class Role {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int roleId;
    @Column
    private String title;
    @Column
    private String description;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role(String roleTitle){
        this.title = roleTitle;
    }

    public Role(){
    }
}
