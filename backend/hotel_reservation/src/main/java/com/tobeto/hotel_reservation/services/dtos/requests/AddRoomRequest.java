package com.tobeto.hotel_reservation.services.dtos.requests;

import com.tobeto.hotel_reservation.entities.RoomStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomRequest {
    @NotNull(message = "Hotel Id Boş Olamaz")
    private int hotelId;

    @NotBlank(message = "Oda Tipi Boş Olamaz")
    private String roomType;

    @NotNull(message = "Lütfen Kapesite Giriniz")
    @Min(value = 1, message = "Kapasite 1 kişiden düşük olamaz")
    @Max(value = 8, message = "Kapasite 8 Kişiden fazla olamaz")
    private int capacity;

    @NotNull(message = "Fiyat Alanı Boş Geçilemez")
    @Positive
    private double price;

    @NotNull(message = "Oda Durumu Boş Olamaz")
    private RoomStatus roomStatus;
}
