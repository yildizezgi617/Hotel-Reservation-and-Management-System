package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.entities.Support;
import com.tobeto.hotel_reservation.services.dtos.requests.AddReservationRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateReservationRequest;
import com.tobeto.hotel_reservation.services.dtos.responses.AddReservationResponse;
import com.tobeto.hotel_reservation.services.dtos.responses.ListReservationResponse;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    AddReservationResponse add(AddReservationRequest addReservationRequest);

    void update(UpdateReservationRequest updateReservationRequest);

    Optional<Reservation> findById(int id);

    List<ListReservationResponse> getAll();

    ListReservationResponse getById(int reservationId); // Yeni metod

    List<Object[]> getReservationsByUserId(int userId);

    List<Object[]> findReservationsByHotelId(int hotelId);

}
