package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    public List<Hotel> findByCityName(String cityName);
}
