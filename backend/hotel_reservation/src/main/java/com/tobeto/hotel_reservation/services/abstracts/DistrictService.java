package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.District;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    Optional<District> findById(int id);
    List<District> getDistrictsByCity(int cityId);
}
