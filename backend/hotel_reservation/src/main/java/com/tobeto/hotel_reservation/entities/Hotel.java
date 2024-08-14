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
@Table(name="hotels")
public class Hotel {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber",unique = true)
    private String phoneNumber;

    @Column(name = "hotelStar")
    private int hotelStar;

    @Column(name = "description")
    private String description;

    @ManyToOne //FK
    @JoinColumn(name = "managerId")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<HotelImage> hotelImages;

    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Room> rooms;

    @OneToOne(mappedBy = "hotel")
    //@JsonIgnore
    private HotelAddress hotelAddress;
}
