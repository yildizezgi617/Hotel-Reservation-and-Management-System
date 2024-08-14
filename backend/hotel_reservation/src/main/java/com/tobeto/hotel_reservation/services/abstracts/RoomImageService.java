package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.services.dtos.requests.AddRoomImageRequest;

public interface RoomImageService {
    void add(AddRoomImageRequest addRoomImageRequest);

    void delete(int id);
}
