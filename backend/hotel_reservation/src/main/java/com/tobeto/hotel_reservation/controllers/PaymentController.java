package com.tobeto.hotel_reservation.controllers;


import com.tobeto.hotel_reservation.services.abstracts.PaymentService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddPaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String add(@Valid @RequestBody AddPaymentRequest addPaymentRequest){
        paymentService.add(addPaymentRequest);
        return "Ödeme Başarılı Rezervasyon Onaylandı!";
    }
}
