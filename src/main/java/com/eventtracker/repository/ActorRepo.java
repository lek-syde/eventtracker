package com.eventtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventtracker.model.Actor;

public interface ActorRepo extends JpaRepository<Actor, Long>{

}
