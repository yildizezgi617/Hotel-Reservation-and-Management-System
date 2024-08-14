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
public class AddUserAddressRequest {

    @NotNull(message = "User Id Alanı Boş Geçilemez")
    private int userId;
    @NotNull(message = "District Id Alanı Boş Geçilemez")
    private int districtId;
    @NotBlank(message = "Açık Adres Alanı Boş Geçilemez")
    private String addressText;

}
