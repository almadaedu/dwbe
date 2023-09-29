package com.dwbe.hotelaria.service;

import com.dwbe.hotelaria.entity.Hotel;
import com.dwbe.hotelaria.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    Hotel addHotel(Hotel hotel);
    public List<Hotel> searchHotel(String cityname);
    public Room addRoom(Room room);
    public List<Room>getRoom(String hotelName);

}
