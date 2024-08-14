package com.tobeto.hotel_reservation.services.concrates;

import com.tobeto.hotel_reservation.entities.GuestInformation;
import com.tobeto.hotel_reservation.entities.Reservation;
import com.tobeto.hotel_reservation.repositories.GuestInformationRepository;
import com.tobeto.hotel_reservation.services.abstracts.GuestInformationService;
import com.tobeto.hotel_reservation.services.abstracts.ReservationService;
import com.tobeto.hotel_reservation.services.dtos.requests.AddGuestInformationRequest;
import com.tobeto.hotel_reservation.services.mappers.GuestInformationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestInformationServiceImpl implements GuestInformationService {
    private final GuestInformationRepository guestInformationRepository;
    private final ReservationService reservationService;
    @Override
    public void add(AddGuestInformationRequest addGuestInformationRequest) {
        Optional<Reservation> reservation=reservationService.findById(addGuestInformationRequest.getReservationId());

        if(reservation.isPresent()){
            GuestInformation guestInformation= GuestInformationMapper.INSTANCE.guestInformationFromAddRequest(addGuestInformationRequest);
            int capacity=reservation.get().getRoom().getCapacity();
            int currentGuestCount=guestInformationRepository.countByReservationId(reservation.get().getId());
            if(currentGuestCount<capacity){
                guestInformationRepository.save(guestInformation);
            }
            else {
                throw new RuntimeException("Girmeye Çalıştığınız Misafir Bilgisi Oda Kapasitesinden Fazladır!");
            }
        }
        else{
            throw new RuntimeException("Rezevasyon Id Bulunamadı");
        }
    }

    @Override
    public void delete(int id) {
        Optional<GuestInformation> guestInformation=guestInformationRepository.findById(id);
        if(guestInformation.isPresent()){
            guestInformationRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Bu İd'ye ait bir misafir bilgisi bulunamadı");
        }
    }

    @Override
    public List<GuestInformation> findByReservationId(int reservationId) {
        return guestInformationRepository.findAll()
                .stream()
                .filter(guest -> guest.getReservation().getId() == reservationId)
                .toList();
    }

    @Override
    public Optional<GuestInformation> findById(int id) {
        return guestInformationRepository.findById(id);
    }

}
