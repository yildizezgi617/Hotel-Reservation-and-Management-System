package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
