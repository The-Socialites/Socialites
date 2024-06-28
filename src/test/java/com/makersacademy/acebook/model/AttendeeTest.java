package com.makersacademy.acebook.model;

import com.makersacademy.acebook.repository.AttendeesRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.InstanceOfAssertFactories.type;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AttendeeTest {

    @Autowired
    private AttendeesRepository attendeesRepository;

    @Test
    public void testAttendeeCreation() {
        Event event = new Event();
        User user = new User();
        Attendee attendee = new Attendee();
        attendee.setEvent(event);
        attendee.setUser(user);


        assertNotNull(attendee);
        assertEquals(user, attendee.getUser());
        assertEquals(event, attendee.getEvent());
    }

//    @Transactional
//    @Test
//    public void test_unique_constraint_on_user_event_combination() {
//        User user = new User();
//        Event event = new Event();
//
//        Attendee attendee1 = new Attendee();
//        attendee1.setUser(user);
//        attendee1.setEvent(event);
//
//        Attendee attendee2 = new Attendee();
//        attendee2.setUser(user);
//        attendee2.setEvent(event);
//
//
//        assertThrows(PersistenceException.class, () -> {
//            attendeesRepository.save(attendee1);
//            attendeesRepository.save(attendee2);
//        });

    }




