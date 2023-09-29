package com.dwbe.hotelaria.service;

import com.dwbe.hotelaria.dao.HotelRepository;
import com.dwbe.hotelaria.dao.RoomRepository;
import com.dwbe.hotelaria.entity.Hotel;
import com.dwbe.hotelaria.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;

    @Override
    public Hotel addHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    @Override
    public List<Hotel> searchHotel(String cityname){
        return hotelRepository.findByCityName(cityname);
    }
    @Override
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }
    @Override
    public List<Room>getRoom(String hotelName){
        return roomRepository.getRoomByHotelName(hotelName);
    }

}
