package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Category;
import com.dwbe.hotelaria.model.Room;
import com.dwbe.hotelaria.repositories.CategoryRepository;
import com.dwbe.hotelaria.repositories.RoomRepository;
import com.dwbe.hotelaria.service.CategoryService;
import com.dwbe.hotelaria.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Room>> findAll() {
        List<Room> list = roomService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id){
        Room obj = roomService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Room> insert(@RequestBody Room obj) {
        obj = roomService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{roomId}/category/{categoryId}")
    public Room assignRoomtoCategory(@PathVariable Long roomId, @PathVariable Long categoryId){
        Room room = roomRepository.findById(roomId).get();
        Category category = categoryRepository.findById(categoryId).get();
        room.setCategory(category);
        return roomRepository.save(room);
    }

}
