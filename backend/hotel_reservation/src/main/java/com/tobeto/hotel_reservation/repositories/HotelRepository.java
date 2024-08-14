package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
