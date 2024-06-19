package com.makersacademy.events.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
// Base URL for the controller
public class HomeController {

	@GetMapping
	public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
		return oAuth2AuthenticationToken.getPrincipal().getAttributes();
	}
}
