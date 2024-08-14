package com.tobeto.hotel_reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotel_addresses")
public class HotelAddress {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "addressText")
    private String addressText;

    @ManyToOne //FK
    @JoinColumn(name = "districtId")
    private District district;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelId")
    @JsonIgnore
    private Hotel hotel;

}

