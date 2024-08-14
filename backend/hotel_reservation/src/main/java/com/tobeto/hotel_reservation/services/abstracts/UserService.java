package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService{
   void update(UpdateUserRequest updateUserRequest);

    Optional<User> findById(int id);
    Optional<User> getUserByEmail(String email);
}
