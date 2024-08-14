package com.tobeto.hotel_reservation.controllers;

import com.tobeto.hotel_reservation.services.abstracts.UserAddressService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddUserAddressRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserAddressRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user_address")
@RequiredArgsConstructor
public class UserAddressController {
    private final UserAddressService userAddressService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addUserAddress")
    public String add(@RequestBody @Valid AddUserAddressRequest request){
        userAddressService.add(request);
        return "Kullanıcı Adresi başarıyle eklendi.";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deleteUserAddress")
    public void delete(int id){
        userAddressService.delete(id);
    }

    @PutMapping("updateUserAddress")
    public String update(@RequestBody @Valid UpdateUserAddressRequest request){
        userAddressService.update(request);
        return "Kullanıcı Adresi Başarıyla Güncellendi";
    }
}
