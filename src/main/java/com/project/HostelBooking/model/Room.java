package com.project.HostelBooking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name =  "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer number;

    private BigDecimal price;

    private Integer maxPeopleCount;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UnavailableDate> unavailableDates = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
