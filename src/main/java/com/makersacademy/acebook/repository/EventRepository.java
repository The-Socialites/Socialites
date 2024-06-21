package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

//public interface EventRepository extends CrudRepository<Event, Long> {
//    @Query("SELECT e FROM Event e ORDER BY e.scheduledDate")
//    Iterable<Event> orderByScheduledDate();
//
//    Iterable<Event> findByDate(Date scheduledDate);
//}

public interface EventRepository extends CrudRepository<Event, Long> {

    // Method to fetch all events ordered by scheduledDate
    List<Event> findAllByOrderByScheduledDate();

    // Method to find events by a specific scheduledDate
    List<Event> findByScheduledDateBetween(Date minScheduledDate, Date maxScheduledDate);
}
