package com.dwbe.hotelaria.controller;


import com.dwbe.hotelaria.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> database = new ArrayList<>();

    public void addHotel(Hotel hotel){
        database.add(hotel);
    }

    public void editHotel(Hotel hotel) {
        int index = database.indexOf(hotel);
        if(index > 0){
            database.set(index, hotel);
        }
    }

    public Hotel searchHotel(String hotelName){
        int index = database.indexOf(new Hotel(hotelName));
        if(index < 0){
            return new Hotel();
        }
        Hotel selectHotel = database.get(index);
        return selectHotel;
    }

    public List<Hotel> hotelList(){
        return database;
    }
}
