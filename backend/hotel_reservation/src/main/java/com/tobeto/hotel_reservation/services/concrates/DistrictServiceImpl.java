package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.District;
import com.tobeto.hotel_reservation.repositories.DistrictRepository;
import com.tobeto.hotel_reservation.services.abstracts.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;

    @Override
    public Optional<District> findById(int id) {
        return districtRepository.findById(id);
    }

    @Override
    public List<District> getDistrictsByCity(int cityId) {
        return districtRepository.findByCityId(cityId);
    }
}
