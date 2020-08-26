package com.eventtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eventtracker.model.Event;

public interface EventRepo  extends JpaRepository<Event, Long> {
	
	@Query("select actor.id , COUNT(*) from Event GROUP BY actor" )
    public List<Long> findallEventsSortedByNumberActor();

}
