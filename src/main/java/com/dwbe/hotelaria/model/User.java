package com.dwbe.hotelaria.model;
import jakarta.persistence.*;

@Entity
@Table(name="user",schema="hotelreservation")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;
    @Column
    private int userRoleId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String userName){
        this.name = userName;
    }

    public User(){
    }
}
