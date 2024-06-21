package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    @Query(value="select * from events where e.title like %:keyword% or e.description like %:keyword", nativeQuery = true)
    List<Event> findByKeyword(@Param("keyword") String keyword);

}
