package com.makersacademy.socialites.controller;

import com.makersacademy.socialites.model.Authority;
import com.makersacademy.socialites.model.User;
import com.makersacademy.socialites.repository.AuthoritiesRepository;
import com.makersacademy.socialites.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @GetMapping("/users/new")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/users")
    public RedirectView signup(@ModelAttribute User user) {
        userRepository.save(user);
        Authority authority = new Authority(user.getUsername(), "ROLE_USER");
        authoritiesRepository.save(authority);
        return new RedirectView("/login");
    }
}
