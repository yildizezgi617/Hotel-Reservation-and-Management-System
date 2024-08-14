package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.services.abstracts.HotelImageService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelImageRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelImageController {
    private final HotelImageService hotelImageService;

/*    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addImage")
    public String add(@RequestBody @Valid AddHotelImageRequest request){
    hotelImageService.add(request);
    return "Hotel Image Başarıyla Yüklendi";
    }*/

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload/{hotelId}")
    public ResponseEntity<String> add(@PathVariable int hotelId, @RequestParam("file") MultipartFile file) {
        AddHotelImageRequest request = new AddHotelImageRequest();
        request.setHotelId(hotelId);
        hotelImageService.add(request, file);
        return ResponseEntity.ok("Hotel resmi başarıyla eklendi.");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deleteImage")
    public void delete(int id){
    hotelImageService.delete(id);
    }
}
