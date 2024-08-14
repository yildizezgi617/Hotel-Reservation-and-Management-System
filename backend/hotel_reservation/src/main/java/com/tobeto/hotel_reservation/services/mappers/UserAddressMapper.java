package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.UserAddress;
import com.tobeto.hotel_reservation.services.dtos.requests.AddUserAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAddressMapper {
    UserAddressMapper INSTANCE = Mappers.getMapper(UserAddressMapper.class);

    @Mapping(source = "userId",target = "user.id")
    @Mapping(source = "districtId",target = "district.id")
    UserAddress userAddressFromAddRequest(AddUserAddressRequest addUserAddressRequest);


}
