package com.tobeto.hotel_reservation.services.mappers;

import com.tobeto.hotel_reservation.entities.ResponseToFeedback;
import com.tobeto.hotel_reservation.services.dtos.requests.AddResponseToFeedbackRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseToFeedbackMapper {
    ResponseToFeedbackMapper INSTANCE= Mappers.getMapper(ResponseToFeedbackMapper.class);

    @Mapping(source = "feedbackId",target="feedback.id")
    ResponseToFeedback responseToFeedbackFromAddRequest(AddResponseToFeedbackRequest addResponseToFeedbackRequest);
}
