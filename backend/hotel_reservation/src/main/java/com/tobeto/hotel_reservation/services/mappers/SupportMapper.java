package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.Support;
import com.tobeto.hotel_reservation.services.dtos.requests.AddSupportRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupportMapper {
    SupportMapper INSTANCE= Mappers.getMapper(SupportMapper.class);

    @Mapping(source = "userId",target = "user.id")
    Support supportFromAddRequest(AddSupportRequest addSupportRequest);

}
