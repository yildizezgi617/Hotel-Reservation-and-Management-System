package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.GuestInformation;
import com.tobeto.hotel_reservation.services.dtos.requests.AddGuestInformationRequest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface GuestInformationService {
    void add(AddGuestInformationRequest addGuestInformationRequest);

    void delete(int id);

    List<GuestInformation> findByReservationId(int reservationId);

    Optional<GuestInformation> findById(int id);


}
