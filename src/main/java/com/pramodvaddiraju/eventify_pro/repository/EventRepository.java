package com.pramodvaddiraju.eventify_pro.repository;

import com.pramodvaddiraju.eventify_pro.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
