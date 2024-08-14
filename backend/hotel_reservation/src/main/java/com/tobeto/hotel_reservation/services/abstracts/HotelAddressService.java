package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelAddressRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateHotelAddressRequest;

public interface HotelAddressService {
    void add(AddHotelAddressRequest addHotelAddressRequest);

    void update(UpdateHotelAddressRequest updateHotelAddressRequest);
    void delete(int id);
}
