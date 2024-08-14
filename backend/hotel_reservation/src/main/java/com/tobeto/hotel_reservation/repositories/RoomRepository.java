package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    @Query("SELECT r, h.name, h.hotelStar, ha.addressText, d.name, c.name, h.id FROM Room r " +
            "INNER JOIN r.hotel h " +
            "LEFT JOIN Reservation res ON r.id = res.room.id " +
            "AND (res.enteranceDay < :releaseDay AND res.releaseDay > :enteranceDay) " +
            "AND res.reservationStatus <> 'CANCELED' " +
            "LEFT JOIN h.hotelAddress ha " +
            "LEFT JOIN ha.district d " +
            "LEFT JOIN d.city c " +
            "WHERE res.id IS NULL " +
            "AND (:roomType IS NULL OR r.roomType = :roomType) " +
            "AND (:capacity IS NULL OR r.capacity = :capacity) " +
            "AND (:location IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :location, '%')) " +
            "OR LOWER(d.name) LIKE LOWER(CONCAT('%', :location, '%')))")
    List<Object[]> findAvailableRooms(@Param("enteranceDay") LocalDate enteranceDay,
                                      @Param("releaseDay") LocalDate releaseDay,
                                      @Param("roomType") String roomType,
                                      @Param("capacity") Integer capacity,
                                      @Param("location") String location);
}


//TODO:ŞEHRE GÖRE DE OTEL İÇİN PARAMETRE EKLENEBİLİR