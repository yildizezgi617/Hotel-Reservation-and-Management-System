package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.Notification;
import com.tobeto.hotel_reservation.entities.NotificationStatus;
import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.repositories.NotificationRepository;
import com.tobeto.hotel_reservation.services.abstracts.NotificationService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public void addNotification(AddNotificationRequest addNotificationRequest) {
        Notification notification=new Notification();
        notification.setText(addNotificationRequest.getText());
        notification.setDate(LocalDateTime.now().withNano(0));
        notification.setNotificationStatus(addNotificationRequest.getNotificationStatus());
        notification.setUser(addNotificationRequest.getUser());
        notificationRepository.save(notification);
    }

    @Override
    public void createNotification(Reservation reservation, String text, NotificationStatus status) {
        AddNotificationRequest notificationRequest = new AddNotificationRequest();
        notificationRequest.setText(text);
        notificationRequest.setNotificationStatus(status);
        notificationRequest.setUser(reservation.getUser());
        addNotification(notificationRequest);
    }

    @Override
    public void createNotificationForSupport(User user, String text, NotificationStatus status) {
        AddNotificationRequest notificationRequest = new AddNotificationRequest();
        notificationRequest.setText(text);
        notificationRequest.setNotificationStatus(status);
        notificationRequest.setUser(user);
        addNotification(notificationRequest);
    }
}
