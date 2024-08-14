package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.City;
import com.tobeto.hotel_reservation.repositories.CityRepository;
import com.tobeto.hotel_reservation.services.abstracts.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
       return cityRepository.findAll();
    }
}
