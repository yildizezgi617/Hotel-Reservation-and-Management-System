package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.services.dtos.requests.AddUserAddressRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserAddressRequest;

public interface UserAddressService {
    void add(AddUserAddressRequest addUserAddressRequest);

    void update(UpdateUserAddressRequest updateUserAddressRequest);
    void delete(int id);
}
