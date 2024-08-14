package com.tobeto.hotel_reservation.services.abstracts;

import com.tobeto.hotel_reservation.services.dtos.requests.AddHotelImageRequest;
import org.springframework.web.multipart.MultipartFile;

public interface HotelImageService {
    void add(AddHotelImageRequest addHotelImageRequest, MultipartFile file);

    void delete(int id);
}
