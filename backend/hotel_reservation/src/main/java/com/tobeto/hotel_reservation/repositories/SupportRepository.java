package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.Support;
import com.tobeto.hotel_reservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupportRepository extends JpaRepository<Support,Integer> {
  //  Optional<Support> findByUserId(int userid);
  List<Support> findByUserId(int userId);
}
