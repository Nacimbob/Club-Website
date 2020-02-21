package com.cve.cve.Repositories;

import java.util.List;

import com.cve.cve.Enumeration.EventType;
import com.cve.cve.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event , Long> {

    List<Event> findByVisibleTrue();
    Long countByEventType(EventType eventType);
}