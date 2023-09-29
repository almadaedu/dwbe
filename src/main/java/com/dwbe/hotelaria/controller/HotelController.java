package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.entity.Hotel;
import com.dwbe.hotelaria.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelServiceImpl hotelService;

    @GetMapping(value = "/search_hotel")
    public List<Hotel> searchHotel(@RequestParam("cityName")String cityName)
    {
        return hotelService.searchHotel(cityName);
    }
}
