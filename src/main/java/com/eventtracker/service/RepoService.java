package com.eventtracker.service;

import java.util.List;


import com.eventtracker.model.Repository;

public interface RepoService {
	
	public abstract void createRepository(Repository event);
	   
	public abstract Repository findByRepositoryId(long actorid);
	
	public abstract List<Repository> findAll();

}
