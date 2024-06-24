package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Event;
import com.makersacademy.acebook.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/home")
public class HomeController {

	@Autowired
	EventRepository eventRepository;

	@GetMapping("/events")
	public Iterable<Event> getHomeEvents(@AuthenticationPrincipal Object principal) {
		return eventRepository.findAll();
	}

	@GetMapping("/user")
	public String getCurrentUser(@AuthenticationPrincipal Object principal) {
		String username;

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else if (principal instanceof OAuth2User) {
			username = ((OAuth2User) principal).getAttribute("name");
		} else {
			username = "User";
		}

		return username;
	}
}
