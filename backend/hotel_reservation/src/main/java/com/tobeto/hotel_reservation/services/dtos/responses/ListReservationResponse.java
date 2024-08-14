package com.tobeto.hotel_reservation.services.dtos.responses;

import com.tobeto.hotel_reservation.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListReservationResponse {
    private int id;
    private Room room;
    private Hotel hotel;
    private LocalDate enteranceDay;
    private LocalDate releaseDay;
    private Payment payment;
    private double totalAmount;

}
