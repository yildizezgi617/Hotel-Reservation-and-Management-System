package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.Support;
import com.tobeto.hotel_reservation.services.dtos.requests.AddSupportRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateSupportRequest;

import java.util.List;

public interface SupportService {
    void add(AddSupportRequest addSupportRequest);

    void update(UpdateSupportRequest updateSupportRequest);
    List<Support> getSupportRequestsByUserId(int userId);

}
