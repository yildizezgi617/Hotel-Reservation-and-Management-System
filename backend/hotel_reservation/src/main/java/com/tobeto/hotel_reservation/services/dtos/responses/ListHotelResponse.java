package com.tobeto.hotel_reservation.services.dtos.responses;

import com.tobeto.hotel_reservation.entities.HotelAddress;
import com.tobeto.hotel_reservation.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListHotelResponse {
    private int id;
    private String name;
    private String phoneNumber;
    private int hotelStar;
    private int userId;
    private String description;
    private HotelAddress hotelAddress;
    private List<Room> rooms;
}
