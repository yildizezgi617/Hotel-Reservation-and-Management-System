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
public class AddRoomImageRequest {
    @NotNull(message = "Room Id Boş Geçilemez")
    private int roomId;

    @NotBlank(message = "Room Image Url Boş Olamaz")
    private String imageUrl;

}
