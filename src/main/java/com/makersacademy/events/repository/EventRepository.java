package com.makersacademy.events.repository;

import com.makersacademy.events.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}