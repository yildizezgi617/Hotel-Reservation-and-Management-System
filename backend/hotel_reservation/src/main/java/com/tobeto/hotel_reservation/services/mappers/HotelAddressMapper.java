package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.HotelAddress;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelAddressMapper {
    HotelAddressMapper INSTANCE = Mappers.getMapper(HotelAddressMapper.class);

    @Mapping(source = "hotelId",target = "hotel.id")
    @Mapping(source = "districtId",target = "district.id")
    HotelAddress hotelAddressFromAddRequest(AddHotelAddressRequest addHotelAddressRequest);
}
