package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.service.EventService;
import com.makersacademy.acebook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.makersacademy.acebook.model.Authority;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.AuthoritiesRepository;
import com.makersacademy.acebook.repository.UserRepository;
import com.makersacademy.acebook.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import java.io.IOException;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private EventService eventService;
    @Autowired
    private S3Service s3Service;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model,
                               @RequestParam("profilePicture") MultipartFile profilePicture,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            logger.info("Attempting to save profile picture...");
            String profilePictureUrl = eventService.saveProfilePicture(user, profilePicture);
            user.setProfilePictureUrl(profilePictureUrl);
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation: ", e);
            model.addAttribute("error", "Username already exists. Please choose another one.");
            return "register";
        } catch (IOException e) {
            logger.error("IO exception during profile picture upload: ", e);
            model.addAttribute("error", "Failed to upload profile picture. Please try again.");
            return "register";
        }

        userService.save(user);
        return "redirect:/login";
    }}
