package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.services.dtos.requests.AddReservationRequest;
import com.tobeto.hotel_reservation.services.dtos.responses.AddReservationResponse;
import com.tobeto.hotel_reservation.services.dtos.responses.ListReservationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE= Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "userId",target = "user.id")
    @Mapping(source = "roomId",target = "room.id")
    @Mapping(target = "totalAmount", ignore = true) // totalAmount'u göz ardı et
    Reservation reservationFromAddRequest(AddReservationRequest addReservationRequest);


    AddReservationResponse addResponseFromReservation(Reservation reservation);

    @Mapping(source="reservation.room",target = "room")
    @Mapping(source="reservation.room.hotel",target = "hotel")
    //@Mapping(source="reservation.room.hotel.hotelAddress",target = "hotelAddress")
    @Mapping(source="reservation.payment",target="payment")
    ListReservationResponse listResponseFromReservation(Reservation reservation);

}
