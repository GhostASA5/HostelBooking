package com.project.HostelBooking.web.dto.room;

import com.project.HostelBooking.model.UnavailableDate;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class RoomResponse {

    private Long id;

    private String name;

    private String description;

    private Integer number;

    private BigDecimal price;

    private Integer maxPeopleCount;

    private List<UnavailableDate> unavailableDates = new ArrayList<>();

}
