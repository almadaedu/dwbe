package com.dwbe.hotelaria.model;

import jakarta.persistence.*;

@Entity
@Table(name="customer",schema="hotelreservation")
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int customerId;
    @Column
    private String name;
    @Column
    private String age;
    @Column
    private String rg;
    @Column
    private String cpf;
    @Column
    private String mobile;
    @Column
    private String email;
    @Column
    private String address;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Customer(String customername){
        this.name = customername;
    }

    public Customer(){
    }
}
