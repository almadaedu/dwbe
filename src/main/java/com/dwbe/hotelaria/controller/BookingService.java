package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> database = new ArrayList<>();

    public void addBooking(Booking booking){
        database.add(booking);
    }

    public void editBooking(Booking booking) {
        int index = database.indexOf(booking);
        if(index > 0){
            database.set(index, booking);
        }
    }

    public Booking searchBooking(String bookingName){
        int index = database.indexOf(new Hotel(bookingName));
        if(index < 0){
            return new Booking();
        }
        Booking selectBooking = database.get(index);
        return selectBooking;
    }

    public List<Booking> bookingList(){
        return database;
    }
}
