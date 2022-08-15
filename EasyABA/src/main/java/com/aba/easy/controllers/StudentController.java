package com.aba.easy.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aba.easy.models.Score;
import com.aba.easy.models.Student;
import com.aba.easy.services.ScoreService;
import com.aba.easy.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping("/student/new")
	public String newStudent(HttpSession session, @ModelAttribute("newStudent") Student student, Model model) {
		if(session.getAttribute("loggedInUser")== null) {
			return "redirect:/";
		}
		else {
			return "student.jsp";
		}
	}
	@PostMapping("/student/create") 
	public String createStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "student.jsp"; //add flash message that score didn't save
		}
		else {
			studentService.create(student);
			return "redirect:/dashboard";
		}
	}
//	@PostMapping("/score1/create") 
//	public String createScore(@Valid @ModelAttribute("newScore")Score score, BindingResult result) {
//		if(result.hasErrors()) {
//			return "dashboard.jsp"; //add flash message that score didn't save
//		}
//		scoreService.create(score);
//		return"redirect:/dashboard";
//	}
}
