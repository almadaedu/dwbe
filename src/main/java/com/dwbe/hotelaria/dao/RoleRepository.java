package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.Customer;
import com.dwbe.hotelaria.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleRepository {
    @Repository
    public interface HotelRepository extends JpaRepository<Customer,Integer> {
        public List<Role> findByRole(String role);

    }
}
