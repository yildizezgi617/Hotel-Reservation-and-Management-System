package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.services.abstracts.RoomImageService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddRoomImageRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomImageController {
    private final RoomImageService roomImageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("roomImage")
    public String add(@RequestBody @Valid AddRoomImageRequest request){
        roomImageService.add(request);
        return "Room Image Başarıyla Yüklendi";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deleteRoomImage")
    public void delete(int id){
        roomImageService.delete(id);
    }
}
