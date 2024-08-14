package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.services.dtos.requests.AddPaymentRequest;

public interface PaymentService {
    void add(AddPaymentRequest addPaymentRequest);
}
