package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.services.dtos.requests.AddResponseToFeedbackRequest;

public interface ResponseToFeedbackService {
    void add(AddResponseToFeedbackRequest addResponseToFeedbackRequest);
}
