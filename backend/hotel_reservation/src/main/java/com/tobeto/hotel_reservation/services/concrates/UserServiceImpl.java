package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.repositories.UserRepository;
import com.tobeto.hotel_reservation.services.abstracts.UserService;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserRequest;
import com.tobeto.hotel_reservation.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        // Öncelikle mevcut kullanıcıyı veritabanından al
        Optional<User> optionalUser = userRepository.findById(updateUserRequest.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Güncellenmesi gereken alanları isteğe göre güncelle
            user.setPhoneNumber(updateUserRequest.getPhoneNumber());
            user.setEmail(updateUserRequest.getEmail());
            user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));

            // Kullanıcıyı veritabanına kaydet
            userRepository.save(user);
        } else {
            // Kullanıcı bulunamadığında ne yapılacağına dair kod
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
//TODO Kullanıcı sadece 1 veriyi güncellemek isterse farklı bir yapı ekleyebiliriz!