package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.NotificationStatus;
import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.services.dtos.requests.AddNotificationRequest;

public interface NotificationService {
    void addNotification(AddNotificationRequest addNotificationRequest);
    void createNotification(Reservation reservation, String text, NotificationStatus status);
    void createNotificationForSupport(User user, String text, NotificationStatus status);
}
