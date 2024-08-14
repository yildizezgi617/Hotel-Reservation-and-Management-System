package com.tobeto.hotel_reservation.services.dtos.requests;

import com.tobeto.hotel_reservation.entities.Gender;
import com.tobeto.hotel_reservation.entities.Role;
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
public class RegisterRequest {
    @NotBlank(message = "İsim alanı boş geçilemez")
    private String name;
    @NotBlank(message = "Soyisim alanı boş geçilemez")
    private String surname;
    @NotNull(message = "Cinsiyet alanı boş geçilemez")
    private Gender gender;
    @NotBlank(message = "Telefon numaranızı giriniz")
    @Pattern(regexp = "\\d+", message = "Telefon Numarası Sadece Rakamlardan Oluşmalı")
    private String phoneNumber;
    @NotNull(message = "Kimlik numarası boş geçilemez")
    @Pattern(regexp = "\\d{10,11}", message = "Kimlik numarası 10 veya 11 hane şeklinde olmalıdır.Sayılardan oluşmalıdır")
    private String identificationNumber;
    @NotBlank(message = "Email alanı boş geçilemez")
    @Email(message = "Lütfen geçerli bir mail adresi giriniz")
    private String email;
    @NotNull(message = "Şifre alanı boş geçilemez")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{6,}$", message = "Şifre en az 6 karakter uzunluğunda olmalı, en az bir büyük harf ve en az bir rakam içermelidir.")
    private String password;
    @NotNull(message = "Kullanıcı rolü alanı boş geçilemez")
    private Role role;

}
