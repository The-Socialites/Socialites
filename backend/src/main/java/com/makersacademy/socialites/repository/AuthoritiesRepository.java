package com.makersacademy.socialites.repository;

import com.makersacademy.socialites.model.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepository extends CrudRepository<Authority, Long> {
}
