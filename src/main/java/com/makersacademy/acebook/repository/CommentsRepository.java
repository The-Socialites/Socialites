package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository  extends JpaRepository<Comment, Long> {
}

