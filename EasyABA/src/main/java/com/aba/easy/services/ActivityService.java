package com.aba.easy.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aba.easy.models.Activity;

import com.aba.easy.repositories.ActivityRepository;

@Service
public class ActivityService {
	@Autowired
	private ActivityRepository activityRepo;
	
	//add an activity
	public void create(Activity activity) {
		activityRepo.save(activity);
	}
	//get by id
	public Activity getOne (Long id) {
		return activityRepo.findById(id).orElse(null);
	}
	//find all activities
	public List<Activity> findAll() {
		return activityRepo.findAll();
	}
	//update activity
	public Activity update(Activity activity) {
		return activityRepo.save(activity);
	}
	//delete an activity
	public void delete(Long id) {
		activityRepo.deleteById(id);
	}
}
