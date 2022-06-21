package com.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dao.StudentMapper;
import com.portal.model.Student;
import com.portal.persistence.StudentServiceDb;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentRestController {
	@Autowired
	private StudentServiceDb studentServiceDb;
	@GetMapping("/")
	public String login() {
		return "authenticated";
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudentsDb(){
		return studentServiceDb.getAllStudentsDb();
	}
}
