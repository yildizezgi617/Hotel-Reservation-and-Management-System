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
public class AddFeedbackRequest {
    @NotNull(message = "Reservation Id Boş Olamaz")
    private int reservationId;
    @NotNull(message = "Rating Boş Olamaz")
    private int rating;
    @NotBlank(message = "Comment Boş Olamaz")
    private String comment;
}
