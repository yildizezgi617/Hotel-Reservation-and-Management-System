package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    Optional<Feedback> findByReservationId(int reservationId);

    @Query("SELECT h.name, ro.roomType, r.enteranceDay, r.releaseDay, u.name, u.surname, f.comment, f.date, f.id, rtf.date, rtf.description " +
            "FROM Feedback f " +
            "LEFT JOIN f.responseToFeedback rtf " +
            "INNER JOIN f.reservation r " +
            "INNER JOIN r.user u " +
            "INNER JOIN r.room ro " +
            "INNER JOIN ro.hotel h " +
            "WHERE h.id = :hotelId")
    List<Object[]> findFeedbacksByHotelId(@Param("hotelId") int hotelId);
}
