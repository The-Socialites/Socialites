package com.makersacademy.events.repository;

import com.makersacademy.events.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CommentsRepository  extends JpaRepository<Comment, Long> {
}

