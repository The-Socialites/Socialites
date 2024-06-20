package com.makersacademy.events.repository;

import com.makersacademy.events.model.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepository extends CrudRepository<Authority, Long> {
}
