package com.dwbe.hotelaria.controller;



import com.dwbe.hotelaria.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> database = new ArrayList<>();

    public void add(Customer customer){
        database.add(customer);
    }

    public void editCustomer(Customer customer) {
        int index = database.indexOf(customer);
        if(index > 0){
            database.set(index, customer);
        }
    }

    public Customer searchCustomer(String customerName){
        int index = database.indexOf(new Customer(customerName));
        if(index < 0){
            return new Customer();
        }
        Customer selectCustomer = database.get(index);
        return selectCustomer;
    }

    public List<Customer> customerList(){
        return database;
    }
}
