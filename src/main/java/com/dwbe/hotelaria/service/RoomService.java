package com.dwbe.hotelaria.service;

import com.dwbe.hotelaria.model.Category;
import com.dwbe.hotelaria.model.Room;
import com.dwbe.hotelaria.model.User;
import com.dwbe.hotelaria.repositories.CategoryRepository;
import com.dwbe.hotelaria.repositories.RoomRepository;
import com.dwbe.hotelaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findById(Long id) {
        Optional<Room> obj = roomRepository.findById(id);
        return obj.get();
    }
    public Room insert(Room obj) {
        return roomRepository.save(obj);
    }
    

}
