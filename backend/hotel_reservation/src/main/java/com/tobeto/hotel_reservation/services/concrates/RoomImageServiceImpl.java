package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.Room;
import com.tobeto.hotel_reservation.entities.RoomImage;
import com.tobeto.hotel_reservation.repositories.RoomImageRepository;
import com.tobeto.hotel_reservation.services.abstracts.RoomImageService;
import com.tobeto.hotel_reservation.services.abstracts.RoomService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddRoomImageRequest;
import com.tobeto.hotel_reservation.services.mappers.RoomImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomImageServiceImpl implements RoomImageService {
    private final RoomImageRepository roomImageRepository;
    private final RoomService roomService;

    @Override
    public void add(AddRoomImageRequest addRoomImageRequest) {
        Optional<Room> room=roomService.findById(addRoomImageRequest.getRoomId());

        if(room.isPresent()){
            RoomImage roomImage= RoomImageMapper.INSTANCE.roomImageFromAddRequest(addRoomImageRequest);
            roomImage=roomImageRepository.save(roomImage);
        }
        else{
            throw new RuntimeException("Böyle Bir Oda Bulunamadı");
        }
    }

    @Override
    public void delete(int id) {
        Optional<RoomImage> roomImage=roomImageRepository.findById(id);
        if(roomImage.isPresent()){
            roomImageRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Room Image Id Bulunamadı");
        }
    }
}
