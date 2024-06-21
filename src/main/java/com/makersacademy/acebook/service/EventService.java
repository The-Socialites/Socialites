package com.makersacademy.acebook.service;

import com.makersacademy.acebook.model.Event;
import com.makersacademy.acebook.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public List<Event> getEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    // Get event by keyword
    public List<Event> findByKeyword(String keyword) {
        return eventRepository.findByKeyword(keyword);

    }
}
