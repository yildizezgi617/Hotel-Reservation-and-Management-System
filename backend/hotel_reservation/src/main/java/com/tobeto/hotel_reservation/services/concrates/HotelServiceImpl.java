package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.Hotel;
import com.tobeto.hotel_reservation.entities.Role;
import com.tobeto.hotel_reservation.entities.User;
import com.tobeto.hotel_reservation.repositories.HotelRepository;
import com.tobeto.hotel_reservation.services.abstracts.HotelService;
import com.tobeto.hotel_reservation.services.abstracts.UserService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelRequest;
import com.tobeto.hotel_reservation.services.dtos.requests.UpdateHotelRequest;
import com.tobeto.hotel_reservation.services.dtos.responses.ListHotelResponse;
import com.tobeto.hotel_reservation.services.mappers.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final UserService userService;

    @Override
    public void add(AddHotelRequest addHotelRequest) {
        Optional<User> user = userService.findById(addHotelRequest.getUserId());

        if (user.isEmpty()) {
            throw new RuntimeException("Sistemde kayıtlı böyle bir kullanıcı yoktur!");
        }

        if (user.get().getRole() == Role.USER) {
            throw new RuntimeException("Sistemde kayıtlı böyle bir manager veya admin yoktur!");
        }

        Hotel hotel = HotelMapper.INSTANCE.hotelFromAddRequest(addHotelRequest);
        //hotel.setUser(user.get()); // Otel ile kullanıcıyı ilişkilendir
        hotel.setDescription(addHotelRequest.getDescription());
        hotelRepository.save(hotel);
    }

    @Override
    public void update(UpdateHotelRequest updateHotelRequest) {
        Optional<Hotel> optionalHotel=hotelRepository.findById(updateHotelRequest.getId());
        if(optionalHotel.isPresent()){
            Hotel hotel=optionalHotel.get();
            hotel.setName(updateHotelRequest.getName());
            hotel.setPhoneNumber(updateHotelRequest.getPhoneNumber());
            hotel.setHotelStar(updateHotelRequest.getHotelStar());
            hotelRepository.save(hotel);
        }
        else {
            throw new RuntimeException("Böyle Bir Hotel Bulunamadı!");
        }
    }

   /*@Override
    public List<ListHotelResponse> getAll() {
        List<Hotel> hotels=hotelRepository.findAll();
        List<ListHotelResponse> listHotelResponses = new ArrayList<>();
        for (Hotel hotel : hotels) {
            ListHotelResponse response = new ListHotelResponse();
            response.setUserId(hotel.getUser().getId());
            response.setName(hotel.getName());
            response.setDescription(hotel.getDescription());
            response.setPhoneNumber(hotel.getPhoneNumber());
            response.setStar(hotel.getHotelStar());
            response.setId(hotel.getId());
            listHotelResponses.add(response);
        }
        return listHotelResponses;
    }*/

    @Override
    public List<ListHotelResponse> getAll() {
        List<Hotel> hotels=hotelRepository.findAll();
        List<ListHotelResponse> result=hotels
                .stream()
                .map(hotel -> HotelMapper.INSTANCE.listResponseFromHotel(hotel))
                .toList();
        return result;
    }


    @Override
    public Optional<Hotel> findById(int id) {
        return hotelRepository.findById(id);
    }

}
