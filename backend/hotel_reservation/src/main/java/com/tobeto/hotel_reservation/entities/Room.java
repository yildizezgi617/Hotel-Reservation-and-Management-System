package com.tobeto.hotel_reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rooms")
public class Room {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roomType")
    private String roomType;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "price")
    private double price;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<RoomImage> roomImages;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Reservation> reservations;
}
