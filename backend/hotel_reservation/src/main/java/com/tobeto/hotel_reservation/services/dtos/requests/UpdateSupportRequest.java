package com.tobeto.hotel_reservation.services.dtos.requests;

import com.tobeto.hotel_reservation.entities.DemandStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSupportRequest {

    @NotNull(message = "Support Id Alanı Boş Olamaz")
    private int id;

    //@NotNull(message = "DemandStatus Boş Olamaz!")
    //private DemandStatus demandStatus;

}
