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
@Table(name="user_addresses")
public class UserAddress {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "addressText")
    private String addressText;

    @JsonIgnore
    @ManyToOne //FK
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne //FK
    @JoinColumn(name = "districtId")
    private District district;

}
