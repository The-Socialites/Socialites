package com.makersacademy.events.service;

import com.makersacademy.events.model.Comment;
import com.makersacademy.events.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentsService {

    @Autowired
    private CommentsRepository commentsRepository;

//    public Comment createComment(String content, java.sql.Timestamp createdAt, Long userId, Long eventId) {
//        Comment comment = Comment.builder()
//                .content(content)
//                .createdAt(createdAt)
//                .userId(userId)
//                .eventId(eventId)
//                .build();
//
//        return Comment;
//    }
}
