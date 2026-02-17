package com.pramodvaddiraju.eventify_pro.controller;

import com.pramodvaddiraju.eventify_pro.dto.EventRequest;
import com.pramodvaddiraju.eventify_pro.dto.EventResponse;
import com.pramodvaddiraju.eventify_pro.response.ApiResponse;
import com.pramodvaddiraju.eventify_pro.service.EventService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<ApiResponse<EventResponse>> createEvent(
            @Valid @RequestBody EventRequest eventRequest) {

        EventResponse response = eventService.createEvent(eventRequest);

        ApiResponse<EventResponse> apiResponse =
                new ApiResponse<>(true, "Created", response);

        return ResponseEntity.status(201).body(apiResponse);
    }


    @GetMapping
    public ResponseEntity<ApiResponse<Page<EventResponse>>> getAllEvents(Pageable pageable) {

        Page<EventResponse> events = eventService.getAllEvents(pageable);

        ApiResponse<Page<EventResponse>> apiResponse =
                new ApiResponse<>(true, "Events fetched successfully", events);

        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<EventResponse>> getById(@PathVariable Long id){
        EventResponse getbyId = eventService.getEventById(id);
        ApiResponse<EventResponse> apiResponse = new ApiResponse<>(true, "Event fetched by id", getbyId);

        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<EventResponse>> updateEvent(@Valid @PathVariable Long id, @RequestBody EventRequest eventRequest){
        EventResponse update = eventService.updateEvent(id, eventRequest);
        ApiResponse<EventResponse> apiResponse = new ApiResponse<>(true, "Updated Event Successfully", update);
        return ResponseEntity.ok(apiResponse);
    }


    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long id){
        eventService.deleteEvent(id);
        ApiResponse<Void> apiResponse = new ApiResponse<>(true, "Deleted Event", null);
        return ResponseEntity.ok(apiResponse);
    }
}
