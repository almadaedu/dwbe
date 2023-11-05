package com.dwbe.hotelaria.repositories;

import com.dwbe.hotelaria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
