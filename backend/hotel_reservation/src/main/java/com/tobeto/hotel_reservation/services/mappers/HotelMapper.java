package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.Hotel;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelRequest;
import com.tobeto.hotel_reservation.services.dtos.responses.ListHotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE= Mappers.getMapper(HotelMapper.class);

    @Mapping(source = "userId",target = "user.id")
    Hotel hotelFromAddRequest(AddHotelRequest addHotelRequest);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source="hotel.hotelAddress",target = "hotelAddress")
    @Mapping(source="hotel.rooms",target = "rooms")
    ListHotelResponse listResponseFromHotel(Hotel hotel);

}
