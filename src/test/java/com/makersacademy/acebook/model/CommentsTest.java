package com.makersacademy.acebook.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentsTest {

    @Test
    public void testCommentCreation() {
        Event event = new Event();
        User user = new User();
        Comment comment = new Comment();
        comment.setContent("Test content");
        comment.setEvent(event);
        comment.setUser(user);

        assertNotNull(comment);
        assertEquals("Test content", comment.getContent());
    }
}
