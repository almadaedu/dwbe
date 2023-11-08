package com.dwbe.hotelaria.repositories;

import com.dwbe.hotelaria.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
