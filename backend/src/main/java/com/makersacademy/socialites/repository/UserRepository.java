package com.makersacademy.socialites.repository;

import com.makersacademy.socialites.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
