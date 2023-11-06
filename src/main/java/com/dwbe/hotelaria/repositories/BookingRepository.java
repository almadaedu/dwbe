package com.dwbe.hotelaria.repositories;

import com.dwbe.hotelaria.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
