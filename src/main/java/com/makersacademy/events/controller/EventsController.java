package com.makersacademy.events.controller;

import com.makersacademy.events.model.Event;
import com.makersacademy.events.repository.EventRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class EventsController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    public String index(Model model) throws IOException {
        Iterable<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        model.addAttribute("event", new Event());
        return "events/index";
    }

    @PostMapping("/events")
    public RedirectView create(@ModelAttribute Event event) {
        eventRepository.save(event);
        return new RedirectView("/events");
    }

}