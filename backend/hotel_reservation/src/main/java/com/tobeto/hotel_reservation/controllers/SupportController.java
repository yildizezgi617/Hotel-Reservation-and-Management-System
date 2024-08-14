package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.entities.Support;
import com.tobeto.hotel_reservation.services.abstracts.SupportService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddSupportRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateSupportRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support")
@RequiredArgsConstructor
public class SupportController {
    private final SupportService supportService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addSupport")
    public String add(@Valid @RequestBody AddSupportRequest request){
        supportService.add((request));
        return "Talep İletildi";
    }

    @PutMapping("updateSupport")
    public String update(@Valid @RequestBody UpdateSupportRequest request){
        supportService.update(request);
        return "Talep Kapatıldı";
    }

    @GetMapping("list/{userId}")
    public List<Support> getSupportRequestsByUserId(@PathVariable int userId) {
        return supportService.getSupportRequestsByUserId(userId);
    }
}
