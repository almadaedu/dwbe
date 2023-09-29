package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value="select a.* from hotelreservation.room a,hotelreservation.hotel b where b.hotel_name= ?1 \n" +
            "and a.hotel_id=b.hotel_id",nativeQuery = true)
    public List<Room> getRoomByHotelName(String hotelName);
}
