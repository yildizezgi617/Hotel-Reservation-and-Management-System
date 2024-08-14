package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.ResponseToFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponseToFeedbackRepository extends JpaRepository<ResponseToFeedback,Integer> {

    Optional<ResponseToFeedback> findByFeedbackId(int feedbackId);

}
