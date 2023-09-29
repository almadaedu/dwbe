package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository {

    @Repository
    public interface HotelRepository extends JpaRepository<Customer,Integer> {
        public List<Customer> findByCustomerName(String name);

    }
}
