package com.makersacademy.events.controller;

import com.makersacademy.events.model.User;
import com.makersacademy.events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
// Base URL for the controller
public class HomeController {
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
		Map<String, Object> attributes = oAuth2AuthenticationToken.getPrincipal().getAttributes();
		String email = (String) attributes.get("email");
		String username = (String) attributes.get("name");
		User user = userService.findByUsername(username);
		if (user == null) {
			user = User.builder()
					.email(email)
					.username(username)
					.password("") // Set a dummy password or leave it empty
					.build();
			userService.save(user);
		}

		return attributes;
	}
	@PostMapping("/signup")
	public User registerUser(@RequestBody User user) {
		if (userService.findByUsername(user.getUsername()) != null) {
			throw new RuntimeException("Username already exists");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.save(user);
	}
}
