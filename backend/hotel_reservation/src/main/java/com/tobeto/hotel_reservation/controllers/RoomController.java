package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.entities.Room;
import com.tobeto.hotel_reservation.services.abstracts.RoomService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddRoomRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateRoomRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addRoom")
    public String add(@RequestBody @Valid AddRoomRequest request){
        roomService.add(request);
        return "Oda Başarıyla Oluşturuldu";
    }

    @PutMapping("updateRoom")
    public String update(@RequestBody @Valid UpdateRoomRequest request){
        roomService.update(request);
        return "Oda Başarıyla Güncellendi";
    }

    @GetMapping("/available-rooms")
    public List<Object[]> findAvailableRooms(
            @RequestParam("enteranceDay") LocalDate enteranceDay,
            @RequestParam("releaseDay") LocalDate releaseDay,
            @RequestParam(value = "location", required = true) String location,
            @RequestParam(value = "roomType", required = false) String roomType,
            @RequestParam(value = "capacity", required = false) Integer capacity) {
        return roomService.findAvailableRooms(enteranceDay, releaseDay, roomType, capacity,location);
    }

}
