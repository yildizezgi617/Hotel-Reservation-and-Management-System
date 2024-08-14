package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.entities.GuestInformation;
import com.tobeto.hotel_reservation.services.abstracts.GuestInformationService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddGuestInformationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest")
@RequiredArgsConstructor
public class GuestInformationController {
    private final GuestInformationService guestInformationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add")
    public String addGuests(@Valid @RequestBody List<AddGuestInformationRequest> requests) {
        for (AddGuestInformationRequest request : requests) {
            guestInformationService.add(request);
        }
        return "Misafirler başarıyla eklendi.";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("delete")
    public void delete(int id){
        guestInformationService.delete(id);
    }


    @GetMapping("/reservation/{reservationId}")
    public List<GuestInformation> getByReservationId(@PathVariable int reservationId) {
        return guestInformationService.findByReservationId(reservationId);
    }

}
