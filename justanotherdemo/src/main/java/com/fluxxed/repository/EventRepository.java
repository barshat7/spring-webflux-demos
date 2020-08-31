package com.fluxxed.repository;

import com.fluxxed.model.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventRepository extends ReactiveCrudRepository<Event, Long> {

}
