package com.makersacademy.acebook.model;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentTest {

    @Test
    public void test_create_comment_instance_with_valid_data() {
        User user = new User("john_doe", "password123", "john.doe@example.com", true);
        Event event = new Event();
        Comment comment = new Comment();
        comment.setContent("This is a sample comment");
        comment.setCreatedAt(new Date());
        comment.setUser(user);
        comment.setEvent(event);

        assertEquals("This is a sample comment", comment.getContent());
        assertNotNull(comment.getCreatedAt());
        assertEquals(user, comment.getUser());
        assertEquals(event, comment.getEvent());
    }

    @Test
    public void test_large_content_handling() {
        Comment comment = new Comment();
        String largeContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        comment.setContent(largeContent);
        assertEquals(largeContent, comment.getContent());
    }

    @Test
    public void test_handles_multiple_associations() {
        User user = new User("john_doe", "password", "john.doe@example.com", true);
        Event event = new Event();
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();

        comment1.setUser(user);
        comment1.setEvent(event);

        comment2.setUser(user);
        comment2.setEvent(event);

        assertEquals(user, comment1.getUser());
        assertEquals(user, comment2.getUser());
        assertEquals(event, comment1.getEvent());
        assertEquals(event, comment2.getEvent());
    }

//    @Test
//    public void test_formatted_created_at_valid_date() {
//        Comment comment = new Comment();
//        LocalDateTime now = LocalDateTime.now();
//        comment.setCreatedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
//
//        String formattedDate = comment.getFormattedCreatedAt();
//
//        assertEquals(now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), formattedDate);
//    }

}
