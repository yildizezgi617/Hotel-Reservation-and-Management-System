package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Optional<Payment> findByReservationId(int reservationId);
}
