package com.aba.easy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aba.easy.models.Score;

public interface ScoreRepository extends CrudRepository<Score, Long> {
	List<Score>findAll();

}
