package com.tobeto.hotel_reservation.services.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddHotelRequest {
    @NotNull(message = "Kullanıcı Id Boş Geçilemez.")
    private int userId;
    @NotBlank(message = "Hotel Adı Boş Bırakılamaz")
    private String name;
    @NotBlank(message = "Hotel Adı Boş Bırakılamaz")
    private String description;
    @NotBlank(message = "Telefon Numarası Boş Bırakılamaz")
    @Pattern(regexp = "\\d+", message = "Telefon Numarası Sadece Rakamlardan Oluşmalı")
    private String phoneNumber;
    @Min(value = 1, message = "Değer 1'den Düşük Olamaz")
    @Max(value = 5, message = "Değer 5'den Fazla Olamaz")
    private int hotelStar;
}
