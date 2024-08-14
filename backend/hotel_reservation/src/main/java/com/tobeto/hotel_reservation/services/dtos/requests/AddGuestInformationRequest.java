package com.tobeto.hotel_reservation.services.dtos.requests;

import com.tobeto.hotel_reservation.entities.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddGuestInformationRequest {

    @NotNull(message = "Rezervasyon Id boş geçilemez")
    private int reservationId;
    @NotBlank(message = "İsim alanı boş geçilemez")
    private String name;
    @NotBlank(message = "Soyisim alanı boş geçilemez")
    private String surname;
    @NotNull(message = "Kimlik numarası boş geçilemez")
    @Pattern(regexp = "\\d{10,11}", message = "Kimlik numarası 10 veya 11 hane şeklinde olmalıdır.Sayılardan oluşmalıdır")
    private String identificationNumber;
    @NotNull(message = "Cinsiyet alanı boş geçilemez")
    private Gender gender;

}
