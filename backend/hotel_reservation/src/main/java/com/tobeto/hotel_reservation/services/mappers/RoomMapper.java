package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.Room;
import com.tobeto.hotel_reservation.services.dtos.requests.AddRoomRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE= Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "hotelId",target = "hotel.id")
    Room roomFromAddRequest(AddRoomRequest addRoomRequest);
}
