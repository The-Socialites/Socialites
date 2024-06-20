package com.makersacademy.socialites.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
	@GetMapping(value = "/")
	public RedirectView index() {
		return new RedirectView("/posts");
	}
}
