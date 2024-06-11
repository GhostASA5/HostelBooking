package com.project.HostelBooking.repositories;

import com.project.HostelBooking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
