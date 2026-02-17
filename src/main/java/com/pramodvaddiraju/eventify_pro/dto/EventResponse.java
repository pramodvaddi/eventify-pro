package com.pramodvaddiraju.eventify_pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    private String organizerEmail;
    private String createdAt;
}
