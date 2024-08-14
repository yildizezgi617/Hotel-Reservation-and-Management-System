package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.core.services.JwtService;
import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.services.abstracts.UserService;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    /*@PutMapping("update")
    public String update(@RequestBody @Valid UpdateUserRequest request) {
        userService.update(request);
        return "Güncelleme İşlemi Başarılı";
    }*/

    @PutMapping("/update")
    public String update(@RequestHeader("Authorization") String token, @RequestBody @Valid UpdateUserRequest request) {
        int userId = jwtService.extractUserId(token.substring(7)); // Token'dan kullanıcı ID'sini çıkarma
        request.setId(userId); // Kullanıcı ID'sini request'e set etme
        userService.update(request);
        return "Güncelleme İşlemi Başarılı";
    }


    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String token) {
        String email = jwtService.extracthUserName(token.substring(7)); // Token'dan email çıkarma işlemi
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> {
            return ResponseEntity.notFound().build();
        });
        //TODO:EMAİL YERİNE İD'DEN TOKEN KONTROLÜ YAPTIRABİLİRİZ!!
    }
}
