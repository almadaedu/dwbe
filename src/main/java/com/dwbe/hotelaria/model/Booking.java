package com.dwbe.hotelaria.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="booking",schema="hotelreservation")
public class Booking {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int bookingId;
    @Column
    private String type;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Date date;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Booking(String bookingType){
        this.type = bookingType;
    }

    public Booking(){
    }
}
