package com.aba.easy.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.aba.easy.models.Activity;
import com.aba.easy.models.Score;
import com.aba.easy.models.Student;
import com.aba.easy.services.ActivityService;
import com.aba.easy.services.ScoreService;
import com.aba.easy.services.StudentService;

@Controller
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/activity1/{id}") //put in parameter and have list of activities
	public String viewActivity(@PathVariable("id") Long id,HttpSession session, @ModelAttribute("activity") Activity activity, Model model) {
		if(session.getAttribute("loggedInUser")== null) {
		return "redirect:/";
		}
		else {
			model.addAttribute("activity", activityService.getOne(id));
			model.addAttribute("scores", new Score());
			
		return "LR.jsp";
		}
	}
	
	@GetMapping("/activity1/new")
	public String newImages (@ModelAttribute("newImage") Activity activity, Model model, Student student) {
		model.addAttribute("students", studentService.all());
		return "new.jsp";
	}
	
	@PostMapping("/activity1/create") 
	public String saveImages(@Valid @ModelAttribute("newImage")Activity activity, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp"; //add flash message that score didn't save
		}
		else {
			System.out.println(activity.getStudent());
			activityService.create(activity);
		
			return "redirect:/dashboard";
		}
	}
	@PostMapping("/activity1/scores")
	public String saveScores (@Valid @ModelAttribute("scores")Score score,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dashboard.jsp"; //add flash message that score didn't save
		}
		else {
			
			scoreService.create(score);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("activity1/edit/{id}")
	public String updateActivityForm(@PathVariable Long id, Model model, @ModelAttribute("updateActivity") Activity activity) {
		Activity updateActivity = activityService.getOne(id);
		model.addAttribute("updateActivity", updateActivity);
		model.addAttribute("students", studentService.all());
		return "update.jsp";
	}
	
	@PutMapping("/activity1/update/{id}")
	public String updateActivity(@PathVariable Long id,@Valid @ModelAttribute("updateActivity")Activity activity, BindingResult result ) {
		activityService.update(activity);
		
;		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/activity1/delete/{id}")
	public String deleteActivity(@PathVariable Long id, Activity activity) {
		activityService.delete(id);
		return"redirect:/dashboard";
	}
}
