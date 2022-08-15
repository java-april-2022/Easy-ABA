package com.aba.easy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aba.easy.models.Score;
import com.aba.easy.models.Student;
import com.aba.easy.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	//add a student
	public void create(Student student) {
		studentRepo.save(student);
	}
	
	//find all students
	public List<Student> all() {
		return studentRepo.findAll();
	}
	//find by id 
	public Student findOne(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
}

//public List<Score> all() {
//	return scoreRepo.findAll();
