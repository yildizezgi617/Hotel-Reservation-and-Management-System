package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.entities.Support;
import com.tobeto.hotel_reservation.services.abstracts.ReservationService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddReservationRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateReservationRequest;
import com.tobeto.hotel_reservation.services.dtos.responses.AddReservationResponse;
import com.tobeto.hotel_reservation.services.dtos.responses.ListReservationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addReservation")
    public AddReservationResponse add(@Valid @RequestBody AddReservationRequest request){
        return reservationService.add(request);
    }

    @PutMapping("updateReservation")
    public String update(@Valid @RequestBody UpdateReservationRequest request){
        reservationService.update(request);
        return "Rezervasyon Durumu Başarıyla Güncellendi";
    }

    @GetMapping("reservationlist")
    public List<ListReservationResponse> getAll(){
        return reservationService.getAll();
   }

    @GetMapping("reservationlist/{reservationId}")
    public ListReservationResponse getById(@PathVariable int reservationId) {
        return reservationService.getById(reservationId);
    }

    @GetMapping("list/{userId}/reservations")
    public List<Object[]> getReservationsByUserId(@PathVariable int userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    @GetMapping("/hotel/{hotelId}/reservations")
    public List<Object[]> getReservationsByHotelId(@PathVariable int hotelId) {
        return reservationService.findReservationsByHotelId(hotelId);
    }

}
