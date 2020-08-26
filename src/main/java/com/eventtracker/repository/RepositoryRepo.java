package com.eventtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventtracker.model.Event;
import com.eventtracker.model.Repository;

public interface RepositoryRepo extends JpaRepository<Repository, Long> {

}
