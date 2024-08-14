package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.services.abstracts.AuthService;
import com.tobeto.hotel_reservation.services.dtos.requests.LoginRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("register")
    public String register(@RequestBody @Valid RegisterRequest request){
        authService.register(request);
        return "Kayıt olma işlemi Başarılı";
    }

    @PostMapping("login")
    public String login(@RequestBody @Valid LoginRequest request){
        return authService.login(request);
    }
}
