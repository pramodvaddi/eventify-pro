package com.pramodvaddiraju.eventify_pro.service;

import com.pramodvaddiraju.eventify_pro.dto.EventRequest;
import com.pramodvaddiraju.eventify_pro.dto.EventResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequest);
    Page<EventResponse> getAllEvents(Pageable pageable);
    EventResponse getEventById(Long id);
    EventResponse updateEvent(Long id, EventRequest eventRequest);
    void deleteEvent(Long id);
}
