package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.entities.District;
import com.tobeto.hotel_reservation.services.abstracts.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/by-city/{cityId}")
    public ResponseEntity<List<District>> getDistrictsByCity(@PathVariable int cityId) {
        return ResponseEntity.ok(districtService.getDistrictsByCity(cityId));
    }
}
