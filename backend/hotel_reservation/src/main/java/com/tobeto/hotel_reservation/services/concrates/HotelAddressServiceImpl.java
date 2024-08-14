package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.District;
import com.tobeto.hotel_reservation.entities.Hotel;
import com.tobeto.hotel_reservation.entities.HotelAddress;
import com.tobeto.hotel_reservation.repositories.HotelAddressRepository;
import com.tobeto.hotel_reservation.services.abstracts.DistrictService;
import com.tobeto.hotel_reservation.services.abstracts.HotelAddressService;
import com.tobeto.hotel_reservation.services.abstracts.HotelService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelAddressRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateHotelAddressRequest;
import com.tobeto.hotel_reservation.services.mappers.HotelAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelAddressServiceImpl implements HotelAddressService {
    private final HotelAddressRepository hotelAddressRepository;
    private final DistrictService districtService;
    private final HotelService hotelService;

    @Override
    public void add(AddHotelAddressRequest addHotelAddressRequest) {
        Optional<Hotel> hotel=hotelService.findById(addHotelAddressRequest.getHotelId());
        Optional<District> district = districtService.findById(addHotelAddressRequest.getDistrictId());

        if(hotel.isEmpty()){
            throw new RuntimeException("Böyle Bir Otel Bulunamadı");
        }
        if(district.isEmpty()){
            throw new RuntimeException("Böyle Bir Adres Bulunamadı");
        }

        HotelAddress hotelAddress= HotelAddressMapper.INSTANCE.hotelAddressFromAddRequest(addHotelAddressRequest);
        hotelAddress=hotelAddressRepository.save(hotelAddress);
    }

    @Override
    public void update(UpdateHotelAddressRequest updateHotelAddressRequest) {
        Optional<HotelAddress> optionalHotelAddress=hotelAddressRepository.findById(updateHotelAddressRequest.getId());
        Optional<District> optionalDistrict = districtService.findById(updateHotelAddressRequest.getDistrictId());
        if(optionalHotelAddress.isPresent()&&optionalDistrict.isPresent()){
            HotelAddress hotelAddress=optionalHotelAddress.get();
            hotelAddress.setAddressText(updateHotelAddressRequest.getAddressText());
            hotelAddress.setDistrict(optionalDistrict.get());
            hotelAddressRepository.save(hotelAddress);
        }
        else throw new RuntimeException("Hotel Adres Id Veya Adres Id Yanlış");
    }

    @Override
    public void delete(int id) {
        Optional<HotelAddress> hotelAddress=hotelAddressRepository.findById(id);
        if(hotelAddress.isPresent()){
            hotelAddressRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Böyle Bir Adres Id Bulunamadı");
        }
    }
}
