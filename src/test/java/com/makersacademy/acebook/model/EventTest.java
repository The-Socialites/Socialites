package com.makersacademy.acebook.model;

import org.junit.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EventTest {
    @Test
    public void testEventCreation() {
        User user = new User();
        Event event = new Event();
        Date createdDate = new Date(2024, 01, 01);
        Date scheduledDate = new Date(2024, 12, 31);
        event.setCreatedAt(createdDate);
        event.setScheduledDate(scheduledDate);
        event.setScheduledStartTime("00:00");
        event.setScheduledEndTime("21:59");
        event.setLocation("Newcastle-Upon-Tyne");
        event.setUser(user);
        event.setEventImageUrl("www.image.com");
        event.setAttendees(1L);
        event.setUserAttending(true);


        assertNotNull(event);
        assertEquals(new Date(2024, 01, 01), event.getCreatedAt());
        assertEquals(new Date(2024, 12, 31), event.getScheduledDate());
        assertEquals("00:00", event.getScheduledStartTime());
        assertEquals("21:59", event.getScheduledEndTime());
        assertEquals("Newcastle-Upon-Tyne", event.getLocation());
        assertEquals(user, event.getUser());
        assertEquals("www.image.com", event.getEventImageUrl());
        assertEquals(Long.valueOf(1L), event.getAttendees());
        assertEquals(true, event.getUserAttending());

    }
}
