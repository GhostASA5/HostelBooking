package com.project.HostelBooking.repositories.events;

import com.project.HostelBooking.model.events.RegisterEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterEventsRepository extends MongoRepository<RegisterEvent, String> {
}
