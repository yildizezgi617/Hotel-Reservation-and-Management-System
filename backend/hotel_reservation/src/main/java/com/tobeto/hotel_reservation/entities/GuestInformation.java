package com.tobeto.hotel_reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="guest_informations")
public class GuestInformation {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "identificationNumber")
    private String identificationNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne //FK
    @JsonIgnore
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

}
