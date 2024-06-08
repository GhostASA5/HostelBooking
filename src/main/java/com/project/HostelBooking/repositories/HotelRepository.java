package com.project.HostelBooking.repositories;

import com.project.HostelBooking.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


}
