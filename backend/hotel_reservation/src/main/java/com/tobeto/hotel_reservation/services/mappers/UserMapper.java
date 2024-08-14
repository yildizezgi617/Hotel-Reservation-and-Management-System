package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //User userFromUpdateRequest(UpdateUserRequest updateUserRequest);
}
