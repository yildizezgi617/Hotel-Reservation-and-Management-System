package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.entities.City;
import com.tobeto.hotel_reservation.services.abstracts.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    } //TODO:TEKRAR GÖZDEN GEÇİRİLECEK
}
