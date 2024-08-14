package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository <Reservation,Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.room.id = :roomId AND " +
            "(r.enteranceDay < :releaseDay AND r.releaseDay > :enteranceDay) " +
            "AND r.reservationStatus <> 'CANCELED'")
    List<Reservation> findConflictingReservations(@Param("roomId") int roomId,
                                                  @Param("enteranceDay") LocalDate enteranceDay,
                                                  @Param("releaseDay") LocalDate releaseDay);

    @Query("SELECT r.id, u.name, u.surname, u.phoneNumber, r.enteranceDay, r.releaseDay, r.reservationStatus, r.totalAmount, h.name " +
            "FROM Reservation r " +
            "LEFT JOIN r.room ro " +
            "LEFT JOIN ro.hotel h " +
            "LEFT JOIN r.user u " +
            "WHERE r.user.id = :userId " +
            "ORDER BY r.id DESC")

    List<Object[]> findReservationsByUserId(@Param("userId") int userId);


    @Query("SELECT r.id, r.enteranceDay, r.releaseDay, r.reservationStatus, " +
            "r.totalAmount, ro.roomType, u.name, u.surname, u.identificationNumber, " +
            "u.email, u.gender, u.phoneNumber " +
            "FROM Reservation r " +
            "INNER JOIN r.user u " +
            "INNER JOIN r.room ro " +
            "WHERE ro.hotel.id = :hotelId " +
            "ORDER BY r.id DESC")
    List<Object[]> findReservationsByHotelId(@Param("hotelId") int hotelId);



}

