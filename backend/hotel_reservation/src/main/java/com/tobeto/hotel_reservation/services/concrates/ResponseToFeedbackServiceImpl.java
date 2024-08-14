package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.Feedback;
import com.tobeto.hotel_reservation.entities.NotificationStatus;
import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.entities.ResponseToFeedback;
import com.tobeto.hotel_reservation.repositories.ResponseToFeedbackRepository;
import com.tobeto.hotel_reservation.services.abstracts.FeedbackService;
import com.tobeto.hotel_reservation.services.abstracts.NotificationService;
import com.tobeto.hotel_reservation.services.abstracts.ReservationService;
import com.tobeto.hotel_reservation.services.abstracts.ResponseToFeedbackService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddResponseToFeedbackRequest;
import com.tobeto.hotel_reservation.services.mappers.ResponseToFeedbackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponseToFeedbackServiceImpl implements ResponseToFeedbackService {
    private final ResponseToFeedbackRepository responseToFeedbackRepository;
    private final FeedbackService feedbackService;
    private final NotificationService notificationService;

    @Override
    public void add(AddResponseToFeedbackRequest addResponseToFeedbackRequest) {
        Optional<Feedback> optionalFeedback=feedbackService.findById(addResponseToFeedbackRequest.getFeedbackId());
        Optional<ResponseToFeedback> optionalResponseToFeedback=responseToFeedbackRepository.findByFeedbackId(addResponseToFeedbackRequest.getFeedbackId());
        if(optionalResponseToFeedback.isEmpty()){
            if(optionalFeedback.isPresent()){
                ResponseToFeedback responseToFeedback= ResponseToFeedbackMapper.INSTANCE.responseToFeedbackFromAddRequest(addResponseToFeedbackRequest);
                Reservation reservation=optionalFeedback.get().getReservation();
                responseToFeedback.setDate(LocalDateTime.now().withNano(0));
                notificationService.createNotification(reservation,"Yeni Yorum Cevabı", NotificationStatus.NEWRESPONSEFEEDBACK);
                responseToFeedbackRepository.save(responseToFeedback);
            }
            else {
                throw new RuntimeException("Böyle Bir FeedbackId Bulunamadı.");
            }
        }

        else{
            throw new RuntimeException("Bu Feedback'e ait response zaten mevcut!");
        }

    }
}
