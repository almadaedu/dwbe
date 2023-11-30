package com.dwbe.hotelaria.model;

import com.dwbe.hotelaria.model.enums.BookingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name="booking")

public class Booking implements Serializable {

    @Serial
    private static final long serialVersionUID = 27759670452031371L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moment")
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT" )
    private LocalDateTime moment;

    @Column(name = "booking_status")
    private BookingStatus bookingStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private User client;

    @ManyToMany
    @JoinTable(name = "booked_rooms", joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"))
    private List<Room> rooms = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

}


