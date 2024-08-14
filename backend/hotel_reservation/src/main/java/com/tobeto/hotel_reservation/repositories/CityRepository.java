package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
