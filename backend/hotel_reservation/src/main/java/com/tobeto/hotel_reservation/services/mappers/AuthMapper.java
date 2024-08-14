package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.services.dtos.requests.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);
    //@Mapping(source = "role",target = "role")

    @Mapping(target="password", ignore = true)
    User userFromRegisterRequest(RegisterRequest registerRequest);
}
