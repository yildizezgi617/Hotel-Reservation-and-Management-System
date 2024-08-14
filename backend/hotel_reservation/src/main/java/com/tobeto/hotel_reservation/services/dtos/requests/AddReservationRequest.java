package com.tobeto.hotel_reservation.services.dtos.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddReservationRequest {
    @NotNull(message = "User Id Boş Olamaz!")
    private int userId;
    @NotNull(message = "Room Id Boş Olamaz!")
    private int roomId;
    @NotNull(message = "Enterance Day Boş Olamaz")
    @FutureOrPresent(message = "Gelecek tarih ya da şimdiki tarih olmalıdır.")
    private LocalDate enteranceDay;
    @NotNull(message = "Release Day Boş Olamaz")
    @Future(message = "Gelecek tarih olmalıdır.")
    private LocalDate releaseDay;
}

