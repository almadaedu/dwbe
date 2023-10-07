package com.dwbe.hotelaria.model;

import jakarta.persistence.*;
@Entity
@Table(name="room",schema = "hotelreservation")
public class Room {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int roomId;
    @Column
    private int hotelId;
    @Column
    private int roomNumber;
    @Column
    private String category;
    @Column
    private int status;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public Room(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public Room(){
    }

}
