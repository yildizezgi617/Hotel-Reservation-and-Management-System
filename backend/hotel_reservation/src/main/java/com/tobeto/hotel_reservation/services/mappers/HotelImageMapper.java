package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.HotelImage;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelImageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelImageMapper {
    HotelImageMapper INSTANCE = Mappers.getMapper(HotelImageMapper.class);

    @Mapping(source = "hotelId",target = "hotel.id")
    HotelImage hotelImageFromAddRequest(AddHotelImageRequest addHotelImageRequest);
}
