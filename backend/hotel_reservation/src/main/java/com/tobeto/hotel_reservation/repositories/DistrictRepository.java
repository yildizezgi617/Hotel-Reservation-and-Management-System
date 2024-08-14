package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer> {
    List<District> findByCityId(int cityId);
}
