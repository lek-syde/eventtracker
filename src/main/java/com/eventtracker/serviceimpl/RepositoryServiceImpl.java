package com.eventtracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventtracker.model.Repository;
import com.eventtracker.repository.RepositoryRepo;
import com.eventtracker.service.RepoService;


@Service
public class RepositoryServiceImpl implements RepoService {
	
	@Autowired
	RepositoryRepo reporepo;

	@Override
	public void createRepository(Repository repo) {
		reporepo.save(repo);
	}

	@Override
	public Repository findByRepositoryId(long repoid) {
		
		return reporepo.findById(repoid).get();
	}

	@Override
	public List<Repository> findAll() {
		
		return reporepo.findAll();
	}

}
