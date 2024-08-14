package com.tobeto.hotel_reservation.services.dtos.requests;

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
public class UpdateUserAddressRequest {
    @NotNull(message = "Id alanı boş geçilemez.")
    private int id;
    @NotBlank(message = "Açık Adres Boş Olamaz")
    private String addressText;
    @NotNull(message = "District Id Alanı Boş Olamaz")
    private int district;
}
