package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.Customer;
import com.dwbe.hotelaria.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    public List<Customer> findByPermission(String permission);
}
