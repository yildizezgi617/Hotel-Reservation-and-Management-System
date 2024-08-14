package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.District;
import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.entities.UserAddress;
import com.tobeto.hotel_reservation.repositories.UserAddressRepository;
import com.tobeto.hotel_reservation.services.abstracts.DistrictService;
import com.tobeto.hotel_reservation.services.abstracts.UserAddressService;
import com.tobeto.hotel_reservation.services.abstracts.UserService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddUserAddressRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserAddressRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateUserRequest;
import com.tobeto.hotel_reservation.services.mappers.UserAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAddressServiceImpl implements UserAddressService {
    private final UserAddressRepository userAddressRepository;
    private final DistrictService districtService;
    private final UserService userService;

    @Override
    public void add(AddUserAddressRequest addUserAddressRequest) {
        Optional<User> user = userService.findById(addUserAddressRequest.getUserId());
        Optional<District> district= districtService.findById(addUserAddressRequest.getDistrictId());

        if(user.isEmpty()){
            throw new RuntimeException("Böyle bir Kullanıcı bulunamadı");
        }

        if(district.isEmpty()){
            throw  new RuntimeException("Böyle bir ilçe id bulunamadı");
        }
        UserAddress userAddress = UserAddressMapper.INSTANCE.userAddressFromAddRequest(addUserAddressRequest);
        userAddressRepository.save(userAddress);


    }

    @Override
    public void update(UpdateUserAddressRequest updateUserAddressRequest) {
        Optional<UserAddress> optionalUserAddress=userAddressRepository.findById(updateUserAddressRequest.getId());
        Optional<District> optionalDistrict=districtService.findById(updateUserAddressRequest.getDistrict());

        if(optionalUserAddress.isPresent()&&optionalDistrict.isPresent()){
            UserAddress userAddress=optionalUserAddress.get();
            userAddress.setAddressText(updateUserAddressRequest.getAddressText());
            userAddress.setDistrict(optionalDistrict.get());
            userAddressRepository.save(userAddress);
        }
        else{
            throw new RuntimeException("Kullanıcı Adresi Id'si Veya İlçe Adresi Bulunamadı");
        }
    }

    @Override
    public void delete(int id) {
        Optional<UserAddress> userAddress=userAddressRepository.findById(id);
        if(userAddress.isPresent()){
            userAddressRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Böyle Bir Kullanıcı Adresi Bulunamadı");
        }
    }
}
