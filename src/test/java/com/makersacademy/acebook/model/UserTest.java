package com.makersacademy.acebook.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Test
    public void createUser() {
        User user = new User();
        user.setUsername("ShaniaTwain");
        user.setPassword("password123");
        user.setEmail("test@email.com");
        user.setProfilePictureUrl("www.image.com");
        user.setLanguage("Spanish");
        user.setCity("Barcelona");

        assertNotNull(user);
        assertEquals("ShaniaTwain", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("test@email.com", user.getEmail());
        assertEquals("www.image.com", user.getProfilePictureUrl());
        assertEquals("Spanish", user.getLanguage());
        assertEquals("Barcelona", user.getCity());
    }
}
