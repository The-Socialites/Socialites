package com.makersacademy.socialites.repository;

import com.makersacademy.socialites.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
