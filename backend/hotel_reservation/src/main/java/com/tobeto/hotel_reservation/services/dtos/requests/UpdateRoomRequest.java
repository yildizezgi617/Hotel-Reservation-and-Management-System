package com.tobeto.hotel_reservation.services.dtos.requests;

import com.tobeto.hotel_reservation.entities.RoomStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoomRequest {
    @NotNull(message = "Room Id Alanı Boş Olamaz")
    private int id;
    @NotBlank(message = "Oda Tipi Adı Boş Olamaz")
    private String roomType;
    @NotNull(message = "Kapesite Alanı Boş Bırakılamaz")
    @Min(value = 1, message = "Kapasite 1 kişiden düşük olamaz")
    @Max(value = 8, message = "Kapasite 8 Kişiden fazla olamaz")
    private int capacity;
    @NotNull(message = "Fiyat Alanı Boş Bırakılamaz")
    private double price;
    @NotNull(message = "Room Status Boş Olamaz")
    private RoomStatus roomStatus;
}
