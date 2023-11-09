package com.dwbe.hotelaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "payment")
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = -2757174942044340630L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_moment")
    private Instant moment;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "payment_booking", joinColumns = {
//            @JoinColumn(name = "payment_id", referencedColumnName = "id") }, inverseJoinColumns = {
//            @JoinColumn(name = "booking_id", referencedColumnName = "id") })
//    private Booking booking;

}
