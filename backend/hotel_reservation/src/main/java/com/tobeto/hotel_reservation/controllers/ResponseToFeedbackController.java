package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.services.abstracts.ResponseToFeedbackService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddResponseToFeedbackRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/responseToFeedback")
@RequiredArgsConstructor
public class ResponseToFeedbackController {
    private final ResponseToFeedbackService responseToFeedbackService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addResponseToFeedback")
    public String add(@Valid @RequestBody AddResponseToFeedbackRequest request){
        responseToFeedbackService.add(request);
        return "Feedback Response Başarıyla Oluşturuldu.";
    }
}
