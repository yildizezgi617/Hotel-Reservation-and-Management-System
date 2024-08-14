package com.tobeto.hotel_reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservations")
public class Reservation {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "enteranceDay")
    private LocalDate enteranceDay;

    @Column(name = "releaseDay")
    private LocalDate releaseDay;

    @Column(name = "totalAmount")
    private double totalAmount;

    @ManyToOne //FK
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    @ManyToOne //FK
    @JsonIgnore
    @JoinColumn(name = "roomId")
    private Room room;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Payment payment;

    @OneToMany(mappedBy = "reservation")
    private List<GuestInformation> guestInformations;


    @OneToOne(mappedBy = "reservation")
    private Feedback feedback;
}
