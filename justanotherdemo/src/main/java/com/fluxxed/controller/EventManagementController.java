package com.fluxxed.controller;

import com.fluxxed.model.Event;
import com.fluxxed.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventManagementController {

  private final EventRepository eventRepository;

  @GetMapping
  Flux<Event> allEvents() {
    return eventRepository.findAll();
  }

  @GetMapping("/event-names")
  Flux<String> eventNames() {
    return eventRepository.findAll()
        .map(Event::getEventName);
  }

}
