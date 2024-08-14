package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.Feedback;
import com.tobeto.hotel_reservation.services.dtos.requests.AddFeedbackRequest;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    void add(AddFeedbackRequest addFeedbackRequest);

    Optional<Feedback> findById(int id);
    List<Object[]> getFeedbacksByHotelId(int hotelId);
}
