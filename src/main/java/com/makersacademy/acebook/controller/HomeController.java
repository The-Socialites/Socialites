package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Event;
import com.makersacademy.acebook.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	EventRepository eventRepository;

	@RequestMapping(value = "/")
	public RedirectView index() {
		return new RedirectView("/home");
	}

	@GetMapping("/home")
	public String home(Model model, @AuthenticationPrincipal Object principal) {
		String username;

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else if (principal instanceof OAuth2User) {
			username = ((OAuth2User) principal).getAttribute("name");
		} else {
			username = "User";
		}

		model.addAttribute("name", username);

		Iterable<Event> events = eventRepository.findAllByOrderByScheduledDate();
		model.addAttribute("events", events);
		model.addAttribute("event", new Event());
		return "home";
	}

	@GetMapping("/home/search")
	public ModelAndView search(Model model,
							   @AuthenticationPrincipal Object principal,
							   @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date scheduledStartDate,
							   @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-mm-dd") Date scheduledEndDate) {
		List<Event> events;

		if (scheduledStartDate != null && scheduledEndDate != null) {
			events = eventRepository.findByScheduledDate(scheduledStartDate, scheduledEndDate);
		} else {
			events = eventRepository.findAllByOrderByScheduledDate();
		}

		ModelAndView modelAndView = new ModelAndView("/home");
		modelAndView.addObject("events", events);
		return modelAndView;
	}

}
