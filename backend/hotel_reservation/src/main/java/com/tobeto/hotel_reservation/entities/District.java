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
@Table(name="districts")
public class District {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne //FK
    @JoinColumn(name = "cityId")
    private City city;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    private List<UserAddress> userAddresses;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    private List<HotelAddress> hotelAddresses;
}
