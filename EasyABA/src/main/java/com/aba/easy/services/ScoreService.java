package com.aba.easy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aba.easy.models.Score;
import com.aba.easy.repositories.ScoreRepository;

@Service
public class ScoreService {
	@Autowired
	private ScoreRepository scoreRepo;
	
	//list all scores
	public List<Score> all() {
		return scoreRepo.findAll();
	}
	//new score
	public Score create (Score score) {
		return scoreRepo.save(score);
	}
	// get one by id
	public Score getOne (Long id) {
		return scoreRepo.findById(id).orElse(null);
	}
	// update score
	public Score update(Score score) {
		return scoreRepo.save(score);
	}
}
