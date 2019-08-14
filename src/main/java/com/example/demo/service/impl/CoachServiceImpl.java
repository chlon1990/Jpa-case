package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CoachNew;
import com.example.demo.repository.mongodb.CoachDataRepo;
import com.example.demo.service.CoachService;

@Service
public class CoachServiceImpl implements CoachService {
	
	private CoachDataRepo coachDataRepo;

	@Override
	public void saveCoach(CoachNew coach) {
		coachDataRepo.save(coach);
	}

}
