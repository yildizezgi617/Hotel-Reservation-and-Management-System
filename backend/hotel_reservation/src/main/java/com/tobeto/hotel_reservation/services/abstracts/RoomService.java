package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.Room;
import com.tobeto.hotel_reservation.services.dtos.requests.AddRoomRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateRoomRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    void add(AddRoomRequest addRoomRequest);

    void update(UpdateRoomRequest updateRoomRequest);

    Optional<Room> findById(int id);

    List<Object[]> findAvailableRooms(LocalDate enteranceDay, LocalDate releaseDay, String roomType, Integer capacity, String location);
}
