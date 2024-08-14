package com.tobeto.hotel_reservation.services.dtos.requests;

import com.tobeto.hotel_reservation.entities.ReservationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationRequest {

    @NotNull(message = "Rezervasyon Id Boş Olamaz!")
    private int id;

    @NotNull(message = "ReservationStatus Boş Olamaz!")
    private ReservationStatus reservationStatus;

}
