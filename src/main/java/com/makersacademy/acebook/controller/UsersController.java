package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Authority;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.AuthoritiesRepository;
import com.makersacademy.acebook.repository.UserRepository;
import com.makersacademy.acebook.services.S3Service;
import com.makersacademy.acebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import software.amazon.awssdk.regions.servicemetadata.S3ControlServiceMetadata;

import java.io.IOException;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;
    @Autowired
    private S3Service s3Service;
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

    @PostMapping("/upload")
    public RedirectView uploadProfilePicture(@RequestParam("profilePicture") MultipartFile profilePicture, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);

        try {
            userService.updateUserProfile(user, profilePicture);
        } catch (IOException e) {
            e.printStackTrace();
            return new RedirectView("/profile?error");
        }

        return new RedirectView("/profile");
    }
}
