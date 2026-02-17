package com.pramodvaddiraju.eventify_pro.service;

import com.pramodvaddiraju.eventify_pro.dto.EventRequest;
import com.pramodvaddiraju.eventify_pro.dto.EventResponse;
import com.pramodvaddiraju.eventify_pro.entity.Event;
import com.pramodvaddiraju.eventify_pro.exception.ResourceNotFoundException;
import com.pramodvaddiraju.eventify_pro.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{

    private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private ModelMapper modelMapper;
    private EventRepository eventRepository;

    public EventServiceImpl(ModelMapper modelMapper, EventRepository eventRepository){
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        log.info("Create request initiated");
        Event event = modelMapper.map(eventRequest, Event.class);
        Event createdEvent = eventRepository.save(event);
        log.info("Created event");
        return modelMapper.map(createdEvent, EventResponse.class);
    }

    @Override
    public Page<EventResponse> getAllEvents(Pageable pageable) {

        return eventRepository.findAll(pageable)
                .map(events -> modelMapper.map(events, EventResponse.class));
    }

    @Override
    public EventResponse getEventById(Long id) {
        Event getEvent = eventRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Not found with id: " + id)
        );

        return modelMapper.map(getEvent, EventResponse.class);
    }

    @Override
    public EventResponse updateEvent(Long id, EventRequest eventRequest) {

        Event existingEvent = eventRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found with id: " + id)
        );
        modelMapper.map(eventRequest, existingEvent);
        Event updatedEvent = eventRepository.save(existingEvent);
        return modelMapper.map(updatedEvent, EventResponse.class);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Not found with id: " +id)
        );
        eventRepository.delete(event);

    }
}
