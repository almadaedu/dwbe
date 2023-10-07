package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<Room> database = new ArrayList<>();

    public void addRoom(Room room){
        database.add(room);
    }

    public void editRoom(Room room) {
        int index = database.indexOf(room);
        if(index > 0){
            database.set(index, room);
        }
    }

    public Room searchRoom(int roomNumber){
        int index = database.indexOf(new Room(roomNumber));
        if(index < 0){
            return new Room();
        }
        Room selectRoom = database.get(index);
        return selectRoom;
    }

    public List<Room> roomList(){
        return database;
    }
    
}
