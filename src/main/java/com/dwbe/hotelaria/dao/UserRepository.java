package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findByUserId(String userId);
}
