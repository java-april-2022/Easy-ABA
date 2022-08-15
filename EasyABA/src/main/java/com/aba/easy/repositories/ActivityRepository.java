package com.aba.easy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aba.easy.models.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long>{
	List<Activity>findAll();
}
