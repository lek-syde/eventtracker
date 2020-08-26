package com.eventtracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventtracker.model.Actor;
import com.eventtracker.repository.ActorRepo;
import com.eventtracker.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {
	
	
	@Autowired
	ActorRepo actorrepo;

	@Override
	public void createUpdateActor(Actor actor) {
		actorrepo.save(actor);
		
	}

	@Override
	public Actor findByActorId(long actorid) {
		return actorrepo.findById(actorid).get();
	}

	@Override
	public List<Actor> findAll() {
		return actorrepo.findAll();
	}

	@Override
	public boolean existsByActorId(long actorid) {
		return actorrepo.existsById(actorid);
	}

}
