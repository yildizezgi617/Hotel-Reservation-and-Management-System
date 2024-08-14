package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.Hotel;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateHotelRequest;
import com.tobeto.hotel_reservation.services.dtos.responses.ListHotelResponse;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    void add(AddHotelRequest addHotelRequest);

    void update(UpdateHotelRequest updateHotelRequest);
    //void update(UpdateHotelRequest updateHotelRequest);

    List<ListHotelResponse> getAll();

    Optional<Hotel> findById(int id);
}
