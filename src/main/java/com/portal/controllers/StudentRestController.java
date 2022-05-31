package com.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dao.StudentMapper;
import com.portal.model.Student;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	@Autowired
	private StudentMapper studentMapper;
	@GetMapping("/all")
	public List<Student> findAll(){
		return studentMapper.findAll();
	}
}
