package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.RoomImage;
import com.tobeto.hotel_reservation.services.dtos.requests.AddRoomImageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomImageMapper {
    RoomImageMapper INSTANCE= Mappers.getMapper(RoomImageMapper.class);

    @Mapping(source = "roomId",target = "room.id")
    RoomImage roomImageFromAddRequest(AddRoomImageRequest addRoomImageRequest);
}
