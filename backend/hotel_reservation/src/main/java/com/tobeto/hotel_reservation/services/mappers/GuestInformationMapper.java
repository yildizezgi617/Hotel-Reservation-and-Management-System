package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.GuestInformation;
import com.tobeto.hotel_reservation.services.dtos.requests.AddGuestInformationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GuestInformationMapper {
    GuestInformationMapper INSTANCE= Mappers.getMapper(GuestInformationMapper.class);


    @Mapping(source = "reservationId",target="reservation.id")
    GuestInformation guestInformationFromAddRequest(AddGuestInformationRequest addGuestInformationRequest);

}
