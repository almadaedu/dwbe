package com.dwbe.hotelaria.model;


import jakarta.persistence.*;


@Entity
@Table(name="hotel",schema="hotelreservation")
public class Hotel {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int hotelId;
    @Column
    private String hotelName;
    @Column
    private String type;
    @Column
    private String description;
    @Column
    private String address;
    @Column
    private String rent;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public Hotel(String hotelname){
        this.hotelName = hotelname;
    }

    public Hotel(){
    }
}
