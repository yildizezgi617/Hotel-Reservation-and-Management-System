package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.services.abstracts.HotelAddressService;
import com.tobeto.hotel_reservation.services.abstracts.HotelService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelAddressRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateHotelAddressRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel_address")
@RequiredArgsConstructor
public class HotelAddressController {
    private final HotelAddressService hotelAddressService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addHotelAddress")
    public String add(@Valid @RequestBody AddHotelAddressRequest request){
        hotelAddressService.add(request);
        return "Hotel Adresi Başarıyla Eklendi";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deleteHotelAddress")
    public void delete(int id){
        hotelAddressService.delete(id);
    }

    @PutMapping("updateHotelAddress")
    public String update(@RequestBody @Valid UpdateHotelAddressRequest request){
        hotelAddressService.update(request);
        return "Otel Adresi Güncellendi";
    }

}
