package com.tobeto.hotel_reservation.services.dtos.requests;

import jakarta.validation.constraints.Email;
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
public class UpdateUserRequest {
    @NotNull(message = "İd Alanı Boş Olamaz!")
    private int id;
    @NotBlank(message = "Telefon numaranızı giriniz")
    @Pattern(regexp = "\\d+", message = "Telefon Numarası Sadece Rakamlardan Oluşmalı")
    private String phoneNumber;
    @NotBlank(message = "Email alanı boş geçilemez")
    @Email(message = "Lütfen geçerli bir mail adresi giriniz")
    private String email;
    @NotNull(message = "Şifre alanı boş geçilemez")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{6,}$", message = "Şifre en az 6 karakter uzunluğunda olmalı, en az bir büyük harf ve en az bir rakam içermelidir.")
    private String password;
}
