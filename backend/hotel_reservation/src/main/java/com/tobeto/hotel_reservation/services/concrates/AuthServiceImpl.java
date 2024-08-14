package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.core.services.JwtService;
import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.repositories.UserRepository;
import com.tobeto.hotel_reservation.services.abstracts.AuthService;
import com.tobeto.hotel_reservation.services.dtos.requests.LoginRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.RegisterRequest;
import com.tobeto.hotel_reservation.services.mappers.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest registerRequest) {
        User user = AuthMapper.INSTANCE.userFromRegisterRequest(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        User user=userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Email Bulunamadı"));
        Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        if(!authentication.isAuthenticated()){
            throw new RuntimeException("Eposta veya Password Hatalı");
        }
        Map<String,Object> extraClaims=new HashMap<>();
        extraClaims.put("UserId",user.getId());
        extraClaims.put("Username",user.getName());
        extraClaims.put("UserRole", user.getRole().name());
        return jwtService.generateToken(user.getUsername(),extraClaims);
    }
}
