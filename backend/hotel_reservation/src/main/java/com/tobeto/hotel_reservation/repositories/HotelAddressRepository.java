package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.HotelAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelAddressRepository extends JpaRepository<HotelAddress,Integer> {
}
