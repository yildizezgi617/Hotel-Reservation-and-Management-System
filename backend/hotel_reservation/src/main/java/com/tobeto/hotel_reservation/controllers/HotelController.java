package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.services.abstracts.HotelService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateHotelRequest;
import com.tobeto.hotel_reservation.services.dtos.responses.ListHotelResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("createhotel")
    public String add(@RequestBody @Valid AddHotelRequest request){
        hotelService.add(request);
        return "Hotel Başarıyla Eklendi.";
    }

    @PutMapping("updateHotel")
    public String update(@RequestBody @Valid UpdateHotelRequest request){
        hotelService.update((request));
        return "Hotel Başarıyla Güncellendi";
    }

    @GetMapping("hotellist")
    public List<ListHotelResponse> getAll(){
        return hotelService.getAll();
    }
}
