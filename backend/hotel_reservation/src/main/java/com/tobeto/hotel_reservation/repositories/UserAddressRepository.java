package com.tobeto.hotel_reservation.repositories;

import com.tobeto.hotel_reservation.entities.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {

}
