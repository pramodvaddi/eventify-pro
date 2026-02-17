package com.pramodvaddiraju.eventify_pro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {

    @NotBlank(message = "title cannot be blank")
    private String title;
    @NotBlank(message = "description cannot be blank")
    private String description;
    @NotBlank(message = "location cannot be blank")
    private String location;
    @NotNull(message = "date time cannot be blank")
    private LocalDateTime eventDate;
    @NotBlank(message = "email cannot be blank")
    @Email(message = "email must be valid")
    private String organizerEmail;

}
