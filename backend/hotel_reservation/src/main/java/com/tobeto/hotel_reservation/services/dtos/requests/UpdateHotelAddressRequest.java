package com.tobeto.hotel_reservation.services.dtos.requests;

import com.tobeto.hotel_reservation.entities.District;
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
public class UpdateHotelAddressRequest {
    @NotNull(message = "Hotel Id Boş Geçilemez")
    private int id;
    @NotBlank(message = "Açık Adres Boş Olamaz")
    private String addressText;
    @NotNull(message = "District Id Alanı Boş Olamaz")
    private int districtId;
}
