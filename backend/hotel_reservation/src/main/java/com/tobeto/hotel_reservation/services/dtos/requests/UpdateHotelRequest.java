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
public class UpdateHotelRequest {
    @NotNull(message = "Hotel Id Alanı Boş Olamaz")
    private int id;
    @NotBlank(message = "Hotel Adı Boş Olamaz")
    private String name;
    @NotBlank(message = "Telefon Numarası Alanı Boş Olamaz")
    @Pattern(regexp = "\\d+", message = "Telefon Numarası Sadece Rakamlardan Oluşmalı")
    private String phoneNumber;
    @NotNull(message = "Hotel Star Boş Olamaz")
    @Min(value = 1, message = "Değer 1'den Düşük Olamaz")
    @Max(value = 5, message = "Değer 5'den Fazla Olamaz")
    private int hotelStar;
}

