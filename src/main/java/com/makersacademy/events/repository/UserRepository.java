package com.makersacademy.events.repository;

import com.makersacademy.events.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
