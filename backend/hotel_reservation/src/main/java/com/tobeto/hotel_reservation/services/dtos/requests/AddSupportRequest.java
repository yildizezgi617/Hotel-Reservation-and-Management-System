package com.tobeto.hotel_reservation.services.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSupportRequest {

    @NotNull(message = "UserId Boş Olamaz")
    private int userId;
    @NotBlank(message = "Tittle Boş Olamaz")
    @Length(min = 5, max = 50, message = "Başlık 5 ile 50 karakter arasında olmalıdır.")
    private String title;
    @NotBlank(message = "Text Boş Olamaz")
    @Length(min = 10, max = 300, message = "Text 10 ile 300 karakter arasında olmalıdır.")
    private String text;
}
