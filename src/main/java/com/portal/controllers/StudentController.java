package com.portal.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.dao.StudentMapper;
import com.portal.model.Student;
@Controller
public class StudentController {
	
	
	private StudentMapper studentMapper;
	
	public StudentController (StudentMapper studentMapper) {
		this.studentMapper = studentMapper; 
	}
	
	@GetMapping({"/index", "/", "/home"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		List<Student> list = studentMapper.findAll();
		mav.addObject("students", list);
		return mav;
	}
	
	@GetMapping("/addStudent")
	public ModelAndView addStudent() {
		ModelAndView mav = new ModelAndView("add-student");
		
		Student newStudent = new Student();
		
		mav.addObject("student", newStudent);
		return mav;
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student student) {
		studentMapper.insertStudent(student);
		return "redirect:/index";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student student) {
		studentMapper.updateStudent(student);
		return "redirect:/index";
	}
	@GetMapping("/updateStudentForm")
	public ModelAndView updateStudentForm(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("update-student");
		
		Student student = studentMapper.getStudent(id);
		mav.addObject("student", student);
		
		return mav;
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int id) {
		studentMapper.deleteStudent(id);
		return "redirect:/index";
	}
}
