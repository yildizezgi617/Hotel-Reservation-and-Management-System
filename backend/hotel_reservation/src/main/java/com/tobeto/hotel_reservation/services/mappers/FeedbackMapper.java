package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.Feedback;
import com.tobeto.hotel_reservation.services.dtos.requests.AddFeedbackRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FeedbackMapper {
    FeedbackMapper INSTANCE= Mappers.getMapper(FeedbackMapper.class);

    @Mapping(source = "reservationId",target = "reservation.id")
    Feedback feedbackFromAddRequest(AddFeedbackRequest addFeedbackRequest);

}
