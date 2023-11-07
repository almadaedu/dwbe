package com.dwbe.hotelaria.model;

import com.dwbe.hotelaria.model.enums.BookingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= Booking.TABLE_NAME)

public class Booking implements Serializable {

    public static final String TABLE_NAME = "booking";

    @Serial
    private static final long serialVersionUID = 27759670452031371L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moment")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT" )
    private Instant moment;

    @Column(name = "booking_status")
    private Integer bookingStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

//    public BookingStatus getBookingStatus() {
//        return BookingStatus.valueOf(bookingStatus);
//    }
//    public void setBookingStatus(BookingStatus bookingStatus) {
//        if (bookingStatus != null) {
//            this.bookingStatus = bookingStatus.getCode();
//        }
//    }
//    public Booking (BookingStatus bookingStatus) {
//        setBookingStatus(bookingStatus);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


