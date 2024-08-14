package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.GuestInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestInformationRepository extends JpaRepository<GuestInformation,Integer> {
    int countByReservationId(int reservationId);

    List<GuestInformation> findByReservationId(int reservationId);

}
